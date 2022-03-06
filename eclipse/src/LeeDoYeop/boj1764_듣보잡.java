package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class boj1764_듣보잡 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> job = new HashMap<>();
		List<String> list = new ArrayList<String>();
		for(int i = 0; i<N; i++) {
			String key = br.readLine();
			job.put(key, key);
		}
		for(int i = 0; i<M; i++) {
			String ans = br.readLine();
			if(ans.equals(job.get(ans))) {
				list.add(ans);
			}
		}
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for(int i = 0; i<list.size(); i++)
			sb.append(list.get(i)).append("\n");
		System.out.println(sb.toString());
	}
}
