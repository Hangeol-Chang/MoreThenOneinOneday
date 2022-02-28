import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1620_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //한 줄 읽어서 st에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> pokemons = new HashMap<String, Integer>();
        String[] pokemons2 = new String[n+1];

        for(int i = 1; i <= n; i++){
            //정수값과 스트링 집어넣기
            String tmp = br.readLine();
            pokemons.put(tmp, i);
            pokemons2[i] = tmp;
        }

        for(int i = 0; i < m; i++){
            String input = br.readLine();
            //정수면
            if(input.matches("-?\\d+")){
                sb.append(pokemons2[Integer.parseInt(input)]).append("\n");
            }//정수 아니면
            else{
                sb.append(pokemons.get(input)).append("\n");
            }
        }
        System.out.println(sb);
        
    }    
}
