import java.util.Scanner;
public class BJ2798 {
    public static int maxnum = 0;
    public static int goal = 0;
    public static int[] nums;
    public static int n = 0;

    public static void calcmax(int nowindex, int nownum, int count){
        for(int i = nowindex; i < n; i++){
            int tmp = nownum + nums[i];
            int tmpcount = count + 1;
            //System.out.println("현재 인덱스 : " + i + ", 현재 수 : " + tmp + ", 현재 더한 수 : " + tmpcount + ", 현재 맥스값 : " + maxnum);
            if(tmp <= goal){
                if(tmpcount == 3){
                    if(tmp > maxnum) maxnum = tmp;
                }else if (i + 1 < n){
                    calcmax(i + 1, tmp, tmpcount);
                }
            }
        }
        //System.out.println();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        goal = in.nextInt();            //static으로 선언한 goal에 불러옴.
        in.nextLine();                  //버퍼 비우기

        //하나씩 받기   < 이게 아주 미세하게 빠름.
        nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        
        //한번에 받기
        //nums = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        in.close();
        
        calcmax(0,0,0);
        
        System.out.println(maxnum);
    }
    
}
