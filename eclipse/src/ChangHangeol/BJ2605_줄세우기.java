import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ2605_줄세우기 {
    public static void main(String[] args) throws IOException{
        //링크드리스트 사용.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> nums = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        //일단 처음꺼 더함.
        int num = 1;
        int idx = 1;
        nums.add(num++);
        for(int i = 1; i < n; i++){
            int nidx = idx++ - Integer.parseInt(st.nextToken());
            if(nidx < 0) nidx = 0;
            
            nums.add(nidx, num++);
        }

        StringBuilder sb = new StringBuilder();
        for(int i : nums){
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
