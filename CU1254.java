import java.util.Scanner;
public class CU1254 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int s = (int)in.next().charAt(0);
        int e = (int)in.next().charAt(0);
        in.close();

        for(int i = s; i <= e; i++) System.out.printf("%c ", i);
    }
}
