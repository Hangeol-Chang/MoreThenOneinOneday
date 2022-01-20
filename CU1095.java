import java.util.Scanner;
public class CU1095 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int min = 25;

        for(int i = 0; i < n; i++){
            int now = in.nextInt();
            if(min > now) min = now;
        }
        in.close();
        System.out.println(min);
    }
}
