import java.util.Scanner;
public class BJ2921 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();  
        in.close();
        int sum = 0;

        for(int i = 0; i <= n; i++){
            for (int j = 0 ; j <= i ; j++){
                sum += i + j;        
            }
        }
        System.out.println(sum);
    }
}
