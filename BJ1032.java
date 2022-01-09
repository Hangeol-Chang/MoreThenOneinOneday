import java.util.Scanner;

public class BJ1032 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        String original = in.nextLine();
        original = in.nextLine();

        char[] ori_array = original.toCharArray();

        int len = original.length();
        
        for(int i = 1; i < T; i++){
            String change = in.nextLine();
            char[] ch_array = change.toCharArray();

            for (int j = 0; j < len; j++){
                if(ori_array[j] != '?' && ori_array[j] != ch_array[j]) {
                    ori_array[j] = '?';
                }
            }
        }
        in.close();
        System.out.println(ori_array);

    }
}
