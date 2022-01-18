import java.util.Scanner;

public class CU1257 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int start = in.nextInt();
        int end = in.nextInt();
        in.close();
        
        if(start %2 == 0) start++;

        for(int i = start; i <= end; i += 2){
            System.out.print(i + " ");
        }
    }
}
