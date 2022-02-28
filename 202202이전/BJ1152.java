import java.util.Scanner;

public class BJ1152 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        String[] wor = in.nextLine().split(" ");
        
        int len = wor.length;
        if(len > 0) if(wor[0] == "") len--;
        System.out.println(len);
        in.close();
    }
}