import java.util.Scanner;
public class BJ1989{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        //테스트케이스 입력
        int T = in.nextInt();
        in.nextLine();
        
        for(int t = 1; t <= T; t++){
            sb.append("#" + t + " ");

            //검사할 문자열 입력
            String str = in.nextLine();
            int len = str.length();
            int halfl = len / 2;

            //회문이면 true, 아니면 false
            boolean rot = true;
            for(int i = 0; i < halfl; i++){ if(str.charAt(i) != str.charAt(len-1-i)) rot = false; }
            
            //스트링빌더에 붙이기
            sb.append((rot ? 1 : 0) + "\n");
        }
        System.out.println(sb);
        in.close();
    }
}