
import java.util.Scanner;

/**
 * 계산하라고 준 문제 아닌거같음...수 크기가.
 */ 
public class BJ10157_자리배정 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int X = in.nextInt() -1;
        int Y = in.nextInt();
        int wait = in.nextInt();
        
        if((X+1)*Y < wait){
            System.out.println(0);
            in.close();
            return;
        }
        
        int count = 0;
        int x = 1;
        int y = 0;
        int mod = 1;    //1, 3은 y를 더하는, 2, 4는 x를 더하는.
        while(count < wait){
            //x방향으로 움직일때.
            //XY를 하나씩 빼가면서, count에 더해감.
            if(mod % 2 == 0){
                if(mod == 2){
                    x += X;
                }else{
                    x -= X;
                }
                count += X--;
            }
            else{
                if(mod == 1){
                    y += Y;
                }else{
                    y -= Y;
                }
                count += Y--;
            }
            //System.out.println("mod : " + mod + ", x/y : " + x + " " + y + ", count : " + count);
            mod++;
            if(mod > 4) mod -= 4;
        }
        mod--;
        if(mod == 0) mod = 4;
    
        switch (mod%2) {
            case 0 :        //가로로 이동
                x += (mod-3)*(count-wait);
                break;
            case 1 :        //세로로 이동
                y += (mod-2)*(count-wait);
                break;
        }
        System.out.println(x + " " + y);
        in.close();
    }
}
/*
1000 5
1058
mod : 1, x/y : 1 5, count : 5
mod : 2, x/y : 1000 5, count : 1004
mod : 3, x/y : 1000 1, count : 1008
mod : 4, x/y : 2 1, count : 2006
-2842 1
*/