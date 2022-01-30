//수열 합으로도 풀 수 있을듯.
import java.util.Scanner;
public class BJ2921 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();  
        in.close();
        int sum = 0;

        for(int i = 0; i <= n; i++){
            for (int j = 0 ; j <= i ; j++){
                sum = sum + i + j;        
            }
        }
        System.out.println(sum);
    }
}
