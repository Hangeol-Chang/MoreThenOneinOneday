package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13300_방배정2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] male = new int[6];
		int[] female = new int[6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			if(gender == 1)
				male[Integer.parseInt(st.nextToken())-1]++;
			else
				female[Integer.parseInt(st.nextToken())-1]++;
		}
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			if(male[i]%K == 0)
				cnt += male[i]/K;
			else
				cnt +=  male[i]/K+1;
			if(female[i]%K == 0)
				cnt += female[i]/K;
			else
				cnt += female[i]/K +1;
		}
		System.out.println(cnt);
	}
}

