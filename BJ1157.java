import java.util.Scanner;

public class BJ1157 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String n = in.nextLine();
        in.close();
        int l = n.length();
        int[] charcount = new int[26];

        //32 > 0, 57 > 25
        for(int i = 0; i < l; i++){
            int asc = (int)n.charAt(i);
            //System.out.println(n.charAt(i) + " " + asc);

            if( asc >= 97 ) asc -= 97;
            else    asc -= 65;
            charcount[asc]++;
        }
        int maxindex = 0;
        boolean isdup = false;
        for(int i = 1; i < 26; i++) {
            if(charcount[maxindex] < charcount[i]) {
                maxindex = i;
                isdup = false;
            } else if(charcount[maxindex] == charcount[i]){
                isdup = true;
            }
        }
        if(isdup) System.out.println("?");
        else System.out.println((char)(maxindex + 65));
        
    }
}
