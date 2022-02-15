import java.util.Scanner;
public class SWEA1289 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        in.nextLine();

        for(int t = 1; t <= T; t++){
            sb.append("#" + t + " ");

            String str = in.nextLine();
            int len = str.length();

            int key = 0;
            int tempt = 0;
            for(int i = 0; i < len; i++){
                int tmp = (int)str.charAt(i) - '0';
                if(key != tmp) {
                    key = 1-key;
                    tempt++;
                }
            }
            sb.append(tempt + "\n");
        }
        System.out.println(sb);
        in.close();
    }
}
