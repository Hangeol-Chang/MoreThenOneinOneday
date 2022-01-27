import java.util.Scanner;
public class BJ2231 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.close();
        int num = (int)Math.pow(10, Integer.toString(n).length()-2);
        
        while (true){
            int sum = num;
            int calc  = num;
            while( calc % 10 != 0 ) {
                sum += calc % 10;
                calc /= 10;
            }
            //System.out.println("목표값 : " + n + ", 계산값 : " + num + ", 계산된 값 : " + sum);
            if(n == num) {
                System.out.println(0); 
                break;
            }
            else if(sum == n) {
                System.out.println(num); 
                break;
            }
            ++num;
        }
    }
}
