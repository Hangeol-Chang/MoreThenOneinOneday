import java.util.Scanner;

public class BJ2920{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        String[] inputval = in.nextLine().split(" ");
        in.close();
        int[] intval = new int[7];
        for(int i = 0; i < 7; i++){
            intval[i] = Integer.parseInt(inputval[i]) - Integer.parseInt(inputval[i+1]);
        }
        
        for(int i = 0; i < 6; i++){
            if(intval[i] != intval[i+1]){
                System.out.println("mixed");
                break;
            }
            if(i == 5) {
                if(intval[i] == 1) System.out.println("descending");
                else System.out.println("ascending");
            }
            
        }
    }
}