import java.util.Scanner;

public class BJ1436 {
    public static boolean checkdevil(int num, int n){
        boolean a = false;
        if( num > 0){
            if(num % 10 == 6){
                if(n == 3) a = true;
                else a = checkdevil(num / 10, n+1);
            }else a = checkdevil(num / 10, 1);
        }else a = false;
        return a;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        int num = 666;
        int count = 0;
        while (true){
            if( checkdevil(num, 1) ){
                count++;    
            }
            if( n == count ) break;
            num++;
        }   
        System.out.println(num);
    }
}
/**
 * 66의 앞뒤로 숫자를 끼워 넣는다.

/**
 * 666 ~ 5666, 7666 ~ 9666 9개
 * 6660 ~ 6669 10 + 9 * 0개
 * 총 19 (9*2 + 1)
 * 
 * 10666 ~ 59666, 70666 ~ 99666 19*9개(171)
 * 60666 ~ 65666, 67666 ~ 69666, 66600 ~ 66699 100 + 9*1개
 * 9 * 19개 + (9 + 100)개 = 280개
 * 총 19 + 280 = 299
 * 
 * 100666 ~ 599666, 700666 ~ 999666 280 * 9개 (2520)
 * 600666 ~ 659666, 670666 ~ 699666 (19 * 9개) 666000 ~ 666999 (1000 개) 1000 + 19*9 개
 * 280 * 9개 + 1000 + 19*9 개 = 3691
 * 3990
 * 
 * 3691 * 9 + 10^4 + 280*9개 = 45730
 * 49720
 */
