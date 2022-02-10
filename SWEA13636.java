import java.util.Scanner;

public class SWEA13636 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = in.nextInt();
        
        for(int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");

            //입력받기
            int n = in.nextInt();
            in.nextLine();
            String num = in.nextLine();

            int count = 0;
            int max = 0;
            //charAt으로 불러와서, 1이면 count에 1 더하기
            //0이면 현재 최대랑 비교 후 count 0으로 초기화
            for(int i = 0; i < n; i++){
                if(num.charAt(i) == '1') count++;
                else{
                    if(count > max) max = count;
                    count = 0;
                }
            }
            if(count > max) max = count;
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
