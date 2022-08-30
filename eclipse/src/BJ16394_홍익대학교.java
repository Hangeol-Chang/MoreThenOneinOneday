import java.io.*;

public class BJ16394_홍익대학교 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        
        System.out.print(year - 1946);
    }   
}
