import java.util.Scanner;
public class BJ1259 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(true){
            String s = in.nextLine();
            if(Integer.parseInt(s) == 0) break;

            int len = s.length();
            int half = (len / 2) + 1;

            boolean same = true;
            for(int i = 0; i < half; i++){
                if(s.charAt(i) == s.charAt((len - 1) - i)){ 
                    continue;
                }
                else{
                    same = false;
                    break;
                }
            }
            System.out.println((same)? "yes" : "no");
        }
        in.close();
    }
    
}
