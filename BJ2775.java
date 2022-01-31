import java.util.Scanner;
public class BJ2775 {
    static int[][] floors = new int[15][15];

    public static int calc(int floor, int room){
        if(floors[floor][room] != 0) return floors[floor][room];
        else{
            int tmp = 0;
            for(int i = 1; i <= room; i++){
                tmp += calc(floor-1, i);
            }
            floors[floor][room] = tmp;
            return tmp;
        }
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 15; i++) floors[0][i] = i;

        int T = in.nextInt();

        for(int t = 0; t < T; t++){
            int floor = in.nextInt();
            int room = in.nextInt();

            System.out.println(calc(floor, room));
        }
        in.close();
        
    }
}
