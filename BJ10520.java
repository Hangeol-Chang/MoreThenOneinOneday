import java.util.Scanner;
public class BJ10520 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        int[] rooms = new int[T];

        for(int i = 0; i < T; i++){
            int h = in.nextInt();
            int w = in.nextInt();
            int n = in.nextInt();
            n--;
            
            int xx = n / h + 1;
            int yy = n % h + 1;
            
            rooms[i] = 100* yy + xx;
        }
        in.close();
        for(int i  = 0; i < T; i++){
            System.out.println(rooms[i]);
        }
    }
}
