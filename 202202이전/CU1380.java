import java.util.Scanner;
public class CU1380 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int p = in.nextInt();
        in.close();

        int start = ((p - 6) > 0) ? p - 6 : 1;
        int end = (p > 6) ? 6 : p - 1;
        for(int i = start; i <= end; i++){
            System.out.println(i + " " + (p - i));
        }
    }
}
