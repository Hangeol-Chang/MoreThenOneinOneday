import java.util.Scanner;

public class BJ2675 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        in.nextLine();
        for(int i = 0; i < T; i++){
            String[] arr = in.nextLine().split(" ");
            int rep = Integer.parseInt(arr[0]);

            int len = arr[1].length();
            char[] str_arr = arr[1].toCharArray();
            for(int j = 0; j < len; j++){
                for(int k = 0; k < rep; k++){
                    System.out.print(str_arr[j]);
                }
            }

            System.out.println();
        }
        in.close();


    }
}