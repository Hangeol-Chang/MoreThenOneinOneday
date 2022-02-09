/*
m개의 줄에서 첫번째 자리를 아스키로 변환하여,
숫자가 일정 이상(57)이면 문자, 아니면 숫자
*/
import java.util.ArrayList;
import java.util.Scanner;
public class BJ1620 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<String> pokemons = new ArrayList<>();
        in.nextLine();
        
        for(int i = 0; i < n; i++){
            pokemons.add(in.nextLine());
        }
        for(int i = 0; i < m; i++){
            String input = in.nextLine();
            int tmp = (int)input.charAt(0);

            //이걸 통과하면 문자가 들어온 거.
            if(tmp >= 57) {
                sb.append(pokemons.indexOf(input) + 1).append("\n");
            }else{
                int idx = Integer.parseInt(input);
                sb.append(pokemons.get(idx - 1)).append("\n");
            }
        }
        System.out.println(sb);
        in.close();
    }
}
