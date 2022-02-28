import java.util.Scanner;
public class CU1411 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        boolean[] deck = new boolean[n + 1];
        
        for(int i = 0; i < n - 1; i++){
            deck[in.nextInt()] = true;
        }
        in.close();
        for(int i = 1; i < n+1; i++){
            if (!deck[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}
