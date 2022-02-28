package ChangHangeol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * A B C D E F
 * 0 - 5
 * 1 - 3
 * 2 - 4
 * 
 */

public class BJ2116 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dices = new int[n][];
        for(int i = 0; i < n; i++){
            dices[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        //입력받기 끝.
        
        int max = 0;
        for(int i = 0; i < 6; i++){
            //첫번째꺼 인덱스
            //i, switch(i)가 포함하면 안되는 놈.
            int bot = i;
            int top = swi(i);
            int maxtmp = 0;
            for(int j = 0; j < n; j++){
                //n번째 주사위에서, i번을 바닥으로 놨을 때, 옆면의 최대값 찾기.
                int maxtmptmp = 0;
                for(int d = 0; d < 6; d++)
                    if(d != bot && d != top)
                        maxtmptmp = Math.max(maxtmptmp, dices[j][d]);

                maxtmp += maxtmptmp;
                //System.out.println("주사위번호 : " + j + ", 바닥값, 탑값, 인덱스들 : " + dices[j][bot] + " " + dices[j][top] + " " + bot + " " + top + ", 고른 max값 : " + maxtmptmp + ", 더한값 : " + maxtmp);
                //다음 번의 i 찾아놓고 n 올리기.
                if(j != n-1){
                    for(int d = 0; d < 6; d++)
                        if( dices[j][top] == dices[j+1][d] ){
                            bot = d;
                            top = swi(d);
                            break;
                        }
                }
            }
            //System.out.println();
            max = Math.max(max, maxtmp);
        }
        System.out.println(max);
    }

    //0이 들어왔을때 5, 5가 들어왔을 때 0
    //1은 3, 3은 1, 2는 4, 4는 2로 바꾸는
    public static int swi(int idx){
        if(idx > 0 && idx < 5){
            if(idx%2 == 0) return 6-idx;
            else return 4-idx;
        }else{
            return 5-idx;
        }
    }
}
/*
5 
2 3 1 6 5 4
3 1 2 4 6 5
5 6 4 1 3 2
1 3 6 2 4 5
4 1 6 5 2 3
*/
