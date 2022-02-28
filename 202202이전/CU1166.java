import java.util.Scanner;

public class CU1166 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int y = in.nextInt();
        in.close();

        if( y % 4 == 0){
            if(y % 100 == 0){
                if(y % 400 == 0){
                    System.out.println("yes");
                }
                else System.out.println("no");
            }else{
                System.out.println("yes");
            }
        }else System.out.println("no");
    }
}
