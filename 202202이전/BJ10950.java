import java.util.Scanner;

public class BJ10950 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++){
            String[] ss = in.nextLine().split(" ");
            System.out.println(Integer.parseInt(ss[0]) + Integer.parseInt(ss[1]));
        }
        in.close();
    }
}
