import java.util.Scanner;
public class SWEA1208 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            sb.append("#" + t + " ");

            //덤프횟수
            int dump = in.nextInt();
            //입력받는 건물들의 최대높이
            int maxh = 0;

            //2차원 배열에 다 때려박기
            //O(100^2)
            int[][] buildings = new int[100][100];
            for(int i = 0; i < 100; i++){
                int input = in.nextInt();
                for(int j = 0; j < input; j++){
                    buildings[j][i]++;
                }
                if(input > maxh) maxh = input;
            }
            //제일 높은 건물의 높이와 위치
            int top = maxh * 100 - 1;
            //제일 낮은 건물의 높이와 위치
            int bot = 0;
            //buildings[n/101][n%101]가 위치가 됨.

            // System.out.println("시작");
            // for(int i = 0; i < 100; i++){
            //     for(int j = 0; j < 100; j++) {
            //         System.out.printf("%1d", buildings[i][j]);
            //     }
            //     System.out.println();
            // }
            // System.out.println();

            while(dump > 0) {
                //차있는 고점, 비어있는 저점을 찾음.
                while(buildings[top/100][top%100] == 0) top--;
                while(buildings[bot/100][bot%100] == 1) bot++;
                
                //고점에 있는 것을 저점으로 옮기기
                buildings[top/100][top%100] = 0;
                buildings[bot/100][bot%100] = 1;
                top--;
                bot++;
                dump--;

                // if(dump % 100 == 0){
                //     for(int i = 1; i < 100; i++){
                //         for(int j =1; j < 100; j++) {
                //             System.out.printf("%1d", buildings[i][j]);
                //         }
                //         System.out.println("   " + i);
                //     }
                //     System.out.println();
                // }
            }

            while(buildings[top/100][top%100] == 0) top--;
            while(buildings[bot/100][bot%100] == 1) bot++;

            // System.out.println((top/100) + " " + (bot/100));
            sb.append((top/100) - (bot/100) + 1 + "\n");
        }
        
        System.out.println(sb);
        in.close();
    }
}
