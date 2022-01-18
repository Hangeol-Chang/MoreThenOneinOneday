import java.util.Scanner;
public class CU1259 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        if(!(n % 2 == 0)) n--;
        int sum = 0;
        
        for(int i = n; i > 0; i -= 2){
            sum += i;
        }
        
        System.out.println(sum);
    }
}
