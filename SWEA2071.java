import java.util.Scanner;

public class SWEA2071 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        in.nextLine();
        
        //테스트 케이스동안 반복
        for(int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");

            //다 더하기
            int sum = 0;
            for(int i = 0; i < 10; i++)
                sum += in.nextInt();

            //반올림 처리하고 10으로 나눔
            sum += 5;
            sum /= 10;
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
        in.close();
    }
}
