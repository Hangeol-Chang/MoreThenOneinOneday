import java.io.*;
import java.util.*;

public class BJ4470_줄번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= count; i++)
            sb.append(i + ". " + br.readLine() + "\n");

        System.out.print(sb);
    }
}
