import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ17219 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> idpw = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        //n, m 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //사이트별 비밀번호 등록
        for(int i = 0; i < n; i++){
            String[] tmp = br.readLine().split(" ");
            idpw.put(tmp[0], tmp[1]);
        }

        //입력받는거 바로 검색해서 스트링빌더에 꽂아버리기
        for(int i = 0; i < m; i++){
            sb.append(idpw.get(br.readLine())).append("\n");
        }

        //출력
        System.out.println(sb);
    }
}
