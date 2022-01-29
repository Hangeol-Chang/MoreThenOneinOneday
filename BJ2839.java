import java.util.Scanner;
public class BJ2839 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int num = in.nextInt();
        in.close();
        //수를 5로 나눈 수
        int n = (num % 5) ;

        int c3 = 0;
        int c5 = 0;

        switch (n) {
            case 1:
                c3 = 2;
                break;
            case 2:
                c3 = 4;
                break;
            case 3:
                c3 = 1;
                break;
            case 4:
                c3 = 3;
                break;
            case 0:
                c3 = 0;
                break;
        }
        //System.out.println(c3);
        
        if(num - (c3 * 3) >= 0) {
            c5 = (num - (c3 * 3)) / 5;
            //System.out.print(c3 + " " + c5 + " : ");
            System.out.println(c3 + c5);
        }else System.out.println(-1);
        System.out.println();
    }
}
