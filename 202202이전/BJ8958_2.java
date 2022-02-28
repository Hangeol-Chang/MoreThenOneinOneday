import java.util.Scanner;
public class BJ8958_2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        in.nextLine();
        int[] sums = new int[n];

        for(int i = 0; i < n; i++ ){
            String[] tmp = in.nextLine().split("");

            int l = tmp.length;
            int conti = 0;
            for(int j = 0; j < l; j++) {

                if(tmp[j].equals("O")) {
                    sums[i] += ++conti;
                }
                else conti = 0;
            }
        }
        in.close();

        for(int i = 0 ; i < n; i++) {
            System.out.println(sums[i]);
        }
    }
}
