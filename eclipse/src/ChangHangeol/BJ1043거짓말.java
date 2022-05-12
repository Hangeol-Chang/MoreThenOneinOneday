package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BJ1043거짓말 {
	static int[] p;
	static int[][] party;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 사람 수
		int N = Integer.parseInt(st.nextToken());
		// 파티 수
		int M = Integer.parseInt(st.nextToken());
		// 서로소 집합 생성
		p = new int[N+1];
		for(int i = 0; i <= N; i++) p[i] = i;
		
		// 진실을 아는 사람 입력받기.
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		
		// 진실을 알고있는 사람.
		int truth = 0;
		try {
			truth = Integer.parseInt(st.nextToken());
		} catch(Exception e) {
			// 진실을 알고있는 사람의 수가 0일 때의 처리.
			System.out.println(M);
			return;
		}
		
		for(int i = 1; i < num; i++)
			union(truth, Integer.parseInt(st.nextToken()));
		
		// 파티 입력받기.
		party = new int[M][];
		for(int i = 0; i < M; i++)
			party[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		// 입력받기 끝.
		
		for(int p = 0; p < M; p++) {
			// 모든 파티에 대해,
			int main = party[p][1];
			// 합치기.
			for(int i = 2; i <= party[p][0]; i++)
				union(main, party[p][i]);
		}
		
		// 순회하면서 거짓말 할 수 있는 파티 세기.
		int count = 0;
		truth = findp(truth);
		par : for(int p = 0; p < M; p++) {
			for(int i = 1; i <= party[p][0]; i++) {
				if(truth == findp(party[p][i]))
					continue par;
			}
			// 여기에 도착하면, 거짓말 가능
			count++;
		}
		System.out.println(count);
	}
	
	static int findp(int x) {
		if(p[x] == x) return p[x];
		else return p[x] = findp(p[x]);
	}
	static void union(int x, int y) {
		p[findp(y)] = findp(x);
	}
}
