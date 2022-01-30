import java.util.Scanner;
public class BJ2145 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(true){
            String numstring = in.nextLine();
            if(Integer.parseInt(numstring) == 0) break;

            while(numstring.length() > 1) {
                int builder = 0;
                int l = numstring.length();
                for(int i = 0; i < l; i++)
                    builder += Integer.parseInt(String.valueOf(numstring.charAt(i)));

                numstring = String.valueOf(builder);
            }
            System.out.println(numstring);
        }
        in.close();
    }
}
