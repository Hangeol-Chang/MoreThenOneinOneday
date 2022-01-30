//수열 합으로도 풀 수 있을듯.
import java.util.Scanner;
public class BJ2921_2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();  
        in.close();
        int sum = 0;

        for(int i = 0; i <= n; i++){
            sum = sum + i*(i+1) + (i*(i + 1) / 2);
        }
        System.out.println(sum);
    }
}
