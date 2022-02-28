package ChangHangeol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * n-1의 공간에 "뒤 - 앞"의 갚을 다 저장하고 시작.
 */

public class BJ2491_수열 {
    static int[] nums;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n-1];

        //nums공간에 앞뒤 수의 차를 저장.
        int a = Integer.parseInt(st.nextToken());
        int b = 0;
        for(int i = 0; i < n-1; i++){
            b = Integer.parseInt(st.nextToken());
            nums[i] = (b - a) < 0 ? -1 : (b-a) > 0 ? 1 : 0;
            a = b;
        }

        //증가최댓값 검사
        int start  = 0;
        int count = 1;
        while( start < n-1 ){
            int i = start;
            while(i < n-1 && nums[i] >= 0){ i++; }
            count = Math.max(count, i - start + 1);
            start = ++i;
        }
        //감소최댓값 검사.
        start = 0;
        while( start < n-1 ){
            int i = start;
            while(i < n-1 && nums[i] <= 0){ i++; }
            count = Math.max(count, i - start + 1);
            start = ++i;
        }
        System.out.println(count);
    }
}
