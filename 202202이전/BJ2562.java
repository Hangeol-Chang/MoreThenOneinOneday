import java.util.Scanner;

public class BJ2562 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int[] arr = new int[9];
        int loc = 0;

        for(int i = 0; i < 9; i++) {
            arr[i] = in.nextInt();
            if ( arr[loc] < arr[i] ) loc = i;
        }
        in.close();
        
        System.out.println(arr[loc] + "\n" + (loc + 1) );
    }
}
