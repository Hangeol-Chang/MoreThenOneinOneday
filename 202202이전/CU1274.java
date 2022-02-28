import java.util.Scanner;
public class CU1274 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        in.close();
        
        boolean prime = true;
        for(int i = 2; i < t; i++){
            if( t % i == 0){
                prime = false;
                break;
            }
        }
        System.out.println( (prime) ? "prime" : "not prime");
    }
}
