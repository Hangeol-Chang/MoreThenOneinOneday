import java.util.Scanner;

public class SWEA1204 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        in.nextLine();

        for(int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");
            in.nextLine();

            int[] scores = new int[101];
            //입력받기
            for(int i = 0; i < 1000; i++){
                scores[in.nextInt()]++;
            }

            // for(int i = 0; i < 101; i++){
            //     System.out.println(i + " : " + scores[i]);
            // }
            

            int max = 0;
            int idx = 0;

            for(int i = 0; i < 101; i++){
                if(max <= scores[i]) {
                    max = scores[i];
                    idx = i;
                }
            }
            sb.append(idx).append("\n");
            in.nextLine();

            //System.out.println(idx);
        }
        System.out.println(sb);
    }
}
