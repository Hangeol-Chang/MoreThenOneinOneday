import java.util.Scanner;
import java.util.stream.Stream;

public class SWEA1209 {
    static int[][] nums = new int[100][];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            String junk = in.nextLine();
            sb.append("#" + t + " ");

            //배열 입력받기
            for(int i = 0; i < 100; i++) {
                nums[i] = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int max = 0;

            for(int i = 0; i < 100; i++){
                int tmp = sums(i, "row");
                if(max < tmp) max = tmp;
            }
            for(int i = 0; i < 100; i++){
                int tmp = sums(i, "col");
                if(max < tmp) max = tmp;
            }
            int tmp1 = 0;
            int tmp2 = 0;
            for(int i = 0; i < 100; i++){
                tmp1 += nums[i][i];
                tmp2 += nums[99-i][i];
            }
            int tmp = Math.max(tmp1, tmp2);
            if(max < tmp) max = tmp;

            sb.append(max + "\n");
        }

        System.out.println(sb);
        in.close();
    }
    
    public static int sums(int idx, String Mod){
        int row = 0;
        int col = 0;
        switch (Mod){
            case "col" :
                col = 1;
                break;
            case "row" :
                row = 1;
                break;
        }
        int tmp = 0;
        for(int i = 0; i < 100; i++) tmp += nums[(idx*col) + i*row][(idx*row) + i*col];
        return tmp;
    }
}
