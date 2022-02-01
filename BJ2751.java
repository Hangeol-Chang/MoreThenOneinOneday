//시간초과
//병합 정렬 써도 시간...초과네?

import java.util.Scanner;

public class BJ2751 {
    static int[] data;
    static int[] tmp;

    public static void mergesort(int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergesort(start, mid);
            mergesort(mid+1, end);

            int p = start;
            int q = mid + 1;
            int index = start;

            while( p <= mid || q <= end ) {
                if( q > end || (p <= mid && data[p] < data[q])){ tmp[index++] = data[p++]; }
                else                                           { tmp[index++] = data[q++]; }
            }
            //for(int i = 0; i <= end; i++) System.out.print(tmp[i] + " ");
            //System.out.println();

            for(int i = start; i <= end; i++){ data[i] = tmp[i]; }
        }  
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = in.nextInt();
        data = new int[n];
        tmp = new int[n];

        for(int i = 0; i < n; i++){ data[i] = in.nextInt(); }
        in.close();

        mergesort(0, n-1);

        for(int i : data) sb.append(i).append('\n');
        System.out.println(sb);
    }
}
