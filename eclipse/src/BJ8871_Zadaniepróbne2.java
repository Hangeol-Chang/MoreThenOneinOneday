import java.io.*;

public class BJ8871_Zadaniepróbne2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round = Integer.parseInt(br.readLine()) + 1;
        
        System.out.print(round*2 + " " + round*3);
    }
}