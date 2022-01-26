import java.util.Scanner;

public class BJ1920_2 {
    public static void sort(long[] data, int l, int r){
        int left = l;
        int right = r;
        long pivot = data[(l+r)/2];
        
        do{
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right){    
                long temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);
        
        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }

    public static boolean search(long[] data, long goal, int s, int e){
        int mid = (s + e) / 2;  //index
        //System.out.println("목표 : " + goal + ", 밑 위 중간 : " + s + " " + e + " " + mid);
        if(s <= e) {
            if(goal == data[mid]){  //탐색 성공
                return true;
            } else if (data[mid] < goal) {
                return search(data, goal, mid + 1, e); 
            } else if(data[mid] > goal) { 
                return search(data, goal, s, mid - 1); 
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] data = new long[n+1];    //n개의 데이터 저장

        for(int i = 0; i < n; i++) data[i] = in.nextInt();
        sort(data, 0, n-1);

        int m = in.nextInt(); 
        boolean[] isin = new boolean[m];
        //이분검색으로 바로 때려넣기
        for(int i = 0; i < m; i++) { 
            isin[i] = search(data, in.nextInt(), 0, n); 
            //System.out.println("있나연? : " + isin[i]);
        }
        in.close();
        for(int i = 0; i < m; i++) {
            System.out.println(isin[i] ? 1 : 0);
        }
    }
}
