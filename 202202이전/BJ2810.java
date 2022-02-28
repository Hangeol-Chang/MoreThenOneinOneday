import java.util.Scanner;
public class BJ2810 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        String seats = in.nextLine();
        in.close();
        int l = seats.length();
        int count = 0;

        for(int i = 0; i < l; i++) {
            if(seats.charAt(i) == 'L') count++;
        }
        count /= 2;

        int seat = n + 1 - count;
        System.out.println(seat > n ? n : seat);
    }
}
