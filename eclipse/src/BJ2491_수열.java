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

        int a = Integer.parseInt(st.nextToken());

        int conti = 0;
        for(int i = 0; i < n-2; i++){
            for(int dir = -1; dir <= 1; dir += 2){
                //dir을 어떻게 계산해야 하나.
                //i번째는 세고 넘어감.
                conti = Math.max(conti, ing(i, 1, dir));
            }
        }
        System.out.println(conti);
    }

    public static int ing(int idx, int count, int dir){
        //인덱스를 벗어나면 리턴.
        if(idx+1 >= n) return count;
        if((dir < 0 && nums[idx+1] - nums[idx] <= 0) || (dir > 0 && nums[idx+1] - nums[idx] >= 0))
            return ing(idx+1, count+1, dir); 
        else
            return count;
    }
}
