import java.util.Scanner;
public class BJ1929 {
    /*
    public static boolean primejudge(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0) return true;
        }
        return false;
    }
    */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int m = in.nextInt();
        int n = in.nextInt();
        int sqrtn  = (int)Math.sqrt(n) + 1;
        in.close();
        boolean[] che = new boolean[n+1]; //소수면 false상태
        che[1] = true;
        
        for(int i = 2; i <= sqrtn; i++){
            for(int j = 2; i * j <= n; j++){
                che[i*j] = true;
            }
        }

        /*
        for(int i = 2; i <= sqrtn ; i++){
            if(!che[i]){ 
                System.out.println("돌리는 위치 : " + i);
                che[i] = primejudge(i); 
            }
            if(!che[i]){
                int j = 2;
                while( j * i < n ) che[i * j++] = true;
            }
        }
        */

        for(int i = m; i <= n; i++){
            if(!che[i]) System.out.println(i);
        }
    }
    
}