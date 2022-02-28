import java.util.Scanner;
public class BJ1436_2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        in.close();
        
        int num = 665;

        while(n > 0){
            if(Integer.toString(++num).indexOf("666") > -1) n--;
        }
        System.out.println(num);
    }
}
