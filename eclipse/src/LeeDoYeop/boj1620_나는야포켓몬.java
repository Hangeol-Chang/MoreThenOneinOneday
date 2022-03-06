package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj1620_나는야포켓몬 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> pom1 = new HashMap<>();
		HashMap<String, Integer> pom2 = new HashMap<>();
		for(int i = 1; i<=N; i++) {
			String str = br.readLine();
			pom1.put(i, str);
			pom2.put(str, i);
		}
		for(int i = 1; i<=M; i++) {
			String str = br.readLine();
			if(str.charAt(0) >= '0' && str.charAt(0) <= '9')
				sb.append(pom1.get(Integer.parseInt(str))).append("\n");
			else
				sb.append(pom2.get(str)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
