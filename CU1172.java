import java.util.Scanner;
public class CU1172 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int[] num = new int[3];
        for(int i = 0; i < 3; i++){
            num[i] = in.nextInt();
        }
        in.close();

        //정렬
        while(true){
            boolean isarranged = true;
            for(int i = 0; i < 2; i++){
                if(num[i] > num[i+1]){
                    isarranged = false;
                    int tmp = num[i+1];
                    num[i+1] = num[i];
                    num[i] = tmp;
                }
            }
            if(isarranged) break;
        }
        System.out.println(num[0] + " " + num[1] + " " + num[2]);
    }
}
