import java.util.Scanner;

public class BJ2579 {
    //계단을 입력받을 함수.
    static int[] stair;
    //그 칸의 계단까지 오르는데 얻을 수 있는 최대 점수.
    static int[] score;
    //연속으로 몇 개의 계단을 밟았는지 저장할 배열.
    //count가 0이면 점프애서 들어온거. 1이면 연속으로 밟아온거.
    static int[] conti;
    static int n;
    
    /*
    이전 꺼에 연속으로 들어왔을 경우. < 나한테 못옴. 
            score[i-2] + stair[i].              (count=0)
            score[i-3] + stair[i-1] + stair[i]. (count=1)
            비교
    이전 거에 점프에서 들어왔을 경우.
            score[i-1] + stair[i];              (count=1)
            score[i-2] + stair[i];              (count=0)
    */

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        //n이랑 계단 입력받기.
        n = in.nextInt();
        stair = new int[n+1];
        score = new int[n+1];
        conti = new int[n+1];
        for(int i = 1; i <= n; i++) stair[i] = in.nextInt();
        
        score[1] = stair[1];
        if(n != 1){
            score[2] = stair[1] + stair[2];
            conti[2] = 1;
        }
        for(int i = 3; i <= n; i++){
            int tmp1;
            int tmp2;
            if(conti[i-1] == 1) {
                tmp1 = score[i-2];
                tmp2 = score[i-3] + stair[i-1];
            }
            else{
                tmp1 = score[i-2];
                tmp2 = score[i-1];
            }
            calc(tmp1, tmp2, i);
            //System.out.println(i + ", 값 : " + score[i]);
        }
        System.out.println(score[n]);
        

        in.close();
    }
    public static void calc(int tmp1, int tmp2, int i){
        if(tmp1 >= tmp2){
            score[i] = tmp1 + stair[i];
            conti[i] = 0;
        }else{
            score[i] = tmp2 + stair[i];
            conti[i] = 1;
        }
    }
}