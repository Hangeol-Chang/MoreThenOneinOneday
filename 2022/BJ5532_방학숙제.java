import java.io.*;
import java.util.*;

public class BJ5532_방학숙제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        A += C-1;
        B += D-1;
        int ans1 = A / C;
        int ans2 = B / D;
        
        int time = Math.max(ans1, ans2);
        System.out.print(L - time);
    }
}
