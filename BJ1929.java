import java.util.Scanner;
public class BJ1929 {
    public static boolean primejudge(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int m = in.nextInt();
        int n = in.nextInt();
        boolean[] che = new boolean[n+1]; //소수가 아니면 false상태

        for(int i = 2; i < m ; i++){
            if(!che[i]){
                int num = i;
                che[num] = primejudge(num);
            }
            if(che[num])
            while()
        }
        for(int i = m; i <= n; i++){

        }
    }
    
}