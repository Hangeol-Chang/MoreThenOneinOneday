import java.util.Scanner;
public class SWEA1213 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            sb.append("#" + t + " ");
            in.nextLine(); //필요없는 데이터 버리기
            
            String search = in.nextLine();
            String target = in.nextLine();

            int searchlen = search.length();
            int targetlen = target.length();

            int i = 0;
            int j = 0;
            
            int num = 0;
            while(i < targetlen - searchlen - 1){
                while(j < searchlen) {
                    if(i >= targetlen) break;
                    if(target.charAt(i) != search.charAt(j)) {
                        i = i-j;
                        j = -1;
                    }
                    i++;
                    j++;
                }
                if(j == searchlen){ num ++; }
                i++;
                j = 0;

            }
            sb.append(num + "\n");
        }
        System.out.println(sb);
    }
    
}
