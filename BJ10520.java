import java.util.Scanner;
public class BJ10520 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        // int[] rooms = new int[T];

        for(int i = 0; i < T; i++){
            int h = in.nextInt();
            int w = in.nextInt();
            int n = in.nextInt();
            n--;

            //높이로 나눈 몫에 +1
            int xx = n / h + 1;

            //높이로 나눈 나머지에 +1
            int yy = n % h + 1;
            
            // rooms[i] = 100 * yy + xx;
            sb.append(100 * yy + xx).append("\n");
        }
        in.close();

        //출력
        System.out.println(sb);
        // for(int i  = 0; i < T; i++){
        //     System.out.println(rooms[i]);
        // }
    }
}
