import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ1076_저항 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> ref = new HashMap<>();

        ref.put("black", 0);
        ref.put("brown", 1);
        ref.put("red", 2);
        ref.put("orange", 3);
        ref.put("yellow", 4);
        ref.put("green", 5);
        ref.put("blue", 6);
        ref.put("violet", 7);
        ref.put("grey", 8);
        ref.put("white", 9);

        // 세 개 입력 받기
        
        long ans = 0;
        for(int i = 1; i >= 0; i--) {
            String a = br.readLine();
            ans += ref.get(a) * Math.pow(10, i);
        }
        
        String a = br.readLine();
        ans *= Math.pow(10, ref.get(a));

        System.out.print(ans);
    }
}
