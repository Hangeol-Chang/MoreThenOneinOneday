import java.util.Scanner;
public class BJ1373 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        in.close();

        int l = n.length();
        int l2 = (l + 2) / 3;
        int[] num = new int[l2];

        //* Math.pow(10, (l-1 -i)/3)

        for(int i = l-1; i >= 0; i--){
            //System.out.println((l-1 - i)%3 + " " + (l-1 -i)/3);
            num[(l-1 -i)/3] += Math.pow(2, (l-1 - i)%3) * Integer.parseInt(n.substring(i, i+1));
        }
        for(int i = l2-1; i >= 0; i--) System.out.print(num[i]);
    }
}
