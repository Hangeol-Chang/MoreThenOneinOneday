import java.util.Scanner;
import java.util.stream.Stream;

public class SWEA1966_countsort {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        in.nextLine();

        for(int t = 1; t <= T; t++){
            sb.append("#" + t + " ");
            int n = in.nextInt();
            in.nextLine();
            int[] nums = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            //맥스값 정하기
            int K = 0;
            for(int i = 0; i < n; i++) if( K < nums[i]) K = nums[i];

            int[] count = new int[K+1];
            int[] sortednums = new int[n];

            //카운트 만들기
            for(int num : nums) count[num]++;
            for(int i = 1; i <= K; i++) count[i] += count[i-1];
            
            // for(int num : count) System.out.print(num + " ");
            // System.out.println();

            //카운트정렬
            for(int i = n-1; i >= 0; i--) sortednums[--count[nums[i]]] = nums[i];
            
            //스트링빌더에 넣기
            for(int num : sortednums) sb.append(num + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }    
}
