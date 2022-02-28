import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class BJ10814 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int N = in.nextInt();
        String[][] names = new String[N][2];

        for(int i = 0; i < N; i++){
            names[i][0] = in.next();
            names[i][1] = in.nextLine();
        }
        in.close();

        Arrays.sort(names, new Comparator<String[]>(){
            @Override
            public int compare(String[] s1, String[] s2){
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });

        for(int i = 0; i < N; i++)
            sb.append(names[i][0]).append(names[i][1]).append("\n");
        System.out.println(sb);
    }
}
