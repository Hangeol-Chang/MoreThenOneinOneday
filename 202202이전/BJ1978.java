import java.util.Scanner;
public class BJ1978 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean[] che = new boolean[1001];          //false이면 소수
        che[1] = true;

        int n = in.nextInt();
        
        for(int i = 2; i <= 31; i++){
            if(che[i] == false) {
                for(int j  = 2; j * i <= 1000; j++){
                    che[i * j] = true;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){ if(!che[in.nextInt()]) count++; }
        in.close();
        System.out.println(count);
    }
}
