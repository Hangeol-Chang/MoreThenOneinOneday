package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj14696_딱지2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			List<Integer> A = new ArrayList<Integer>();
			List<Integer> B = new ArrayList<Integer>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			int aC = Integer.parseInt(st.nextToken());
			for (int i = 0; i < aC; i++)
				A.add(Integer.parseInt(st.nextToken()));

			st = new StringTokenizer(br.readLine());
			int bC = Integer.parseInt(st.nextToken());
			for (int i = 0; i < bC; i++)
				B.add(Integer.parseInt(st.nextToken()));

			Collections.sort(A, Collections.reverseOrder());
			Collections.sort(B, Collections.reverseOrder());
			int len = Math.min(A.size(), B.size());
			char winner = 0;
			for (int i = 0; i < len; i++) {
				if (A.get(i) > B.get(i)) {
					winner = 'A';
					break;
				} else if (A.get(i) == B.get(i)) {
					winner = 'D';
					continue;
				} else {
					winner = 'B';
					break;
				}
			}
			if (winner == 'D') {
				if (A.size() > B.size())
					winner = 'A';
				else if (A.size() == B.size())
					winner = 'D';
				else
					winner = 'B';
			}
			sb.append(winner).append("\n");
		}
		System.out.println(sb);
	}
}
