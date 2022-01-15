import java.util.Scanner;

public class BJ8958 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        in.nextLine();
        
        for(int i = 0; i < t; i++){
            String ox = in.nextLine();
            int count = 0;
            int score = 0;

            for(int j = 0; j < ox.length(); j++){
                if( ox.charAt(j) == 'O' ){
                    count++;
                    score += count;
                }else count = 0;
            }
            System.out.println(score);
        }
    }
}