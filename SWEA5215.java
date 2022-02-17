import java.util.Scanner;
public class SWEA5215 {
    static int n;
    static int l = 0;
    static int pmax = 0;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        in.nextLine();

        for(int t = 1; t <= T; t++) {
            pmax = 0;
            sb.append("#" + t + " ");
            n = in.nextInt();
            l  = in.nextInt();

            int[][] food = new int[n][2];
            for(int i = 0; i < n; i++) {
                food[i][0] = in.nextInt();
                food[i][1] = in.nextInt();
            }
            //입력받기 끝.

            powerset(0,0,0,food);
            sb.append(pmax + "\n");
        }
        System.out.println(sb);
    }

    public static void powerset(int index, int psum, int lsum, int[][] foods){
        if(l >= lsum && psum > pmax) { pmax = psum; }
        if(index < n){
            powerset(index + 1, psum, lsum, foods);
            powerset(index + 1, psum + foods[index][0], lsum + foods[index][1], foods);
        }
        return;
    }
}
