import java.util.Scanner;
public class BJ11720 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.nextLine();

        String[] line = in.nextLine().split("");
        int sum = 0;
        for(int i = 0; i < t; i++){     
            sum += Integer.parseInt(line[i]);
        }
        System.out.println(sum);
        in.close();
    }
}
