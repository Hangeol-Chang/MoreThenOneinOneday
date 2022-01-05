import java.util.Scanner;

public class BJ2884 {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        String in2 = in.nextLine();
        String[] hm = in2.split(" ");
        in.close();

        System.out.println(hm[0] + "//" + hm[1]);
        
        int hhm = Integer.parseInt(hm[0]);
        int mmh = Integer.parseInt(hm[1]);
        
    }
}
