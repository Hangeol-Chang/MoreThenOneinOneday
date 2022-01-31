//시간초과
//병합 정렬 사용할 것.

import java.util.Scanner;

public class BJ2751 {
    public static void sort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];
        
        do{
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right){    
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);
        
        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] data = new int[n];

        for(int i = 0; i < n; i++){
            data[i] = in.nextInt();
        }
        in.close();
        sort(data, 0, data.length - 1);

        for(int i  = 0; i < n; i++) System.out.println(data[i]);
    }
}
