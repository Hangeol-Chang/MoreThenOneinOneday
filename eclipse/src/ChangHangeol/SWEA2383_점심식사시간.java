package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA2383_점심식사시간 {
	static class person{
		int r, c;
		int[] d;
		person(int r, int c){
			this.r = r;
			this.c = c;
			d = new int[2];
		}
//		@Override
//		public String toString() {
//			return "person [r=" + r + ", c=" + c + ", d=" + Arrays.toString(d) + "]";
//		}		
	}
	static int N, mintime, peoplenum;
	static ArrayList<person> people;
	static int[][] stair;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 위치를 잡아주고, 이에 대해 거리를 계산해서 넣어줌.
		// 그 후 계단을 내려보내기. 계단에 들어간 사람은, 본인 남은 거리를 -1로 표기.
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		stair = new int[2][3];
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			people = new ArrayList<>();
			
			int tmpcount = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp > 1) {
						stair[tmpcount][0] = i;
						stair[tmpcount][1] = j;
						// 계단 길이.
						stair[tmpcount][2] = tmp;
						tmpcount++;
					}else if (tmp == 1) {
						people.add(new person(i, j));
					}
				}
			}
			// 입력 완료.
			
			for(person p : people) {
				p.d[0] = Math.abs(p.r - stair[0][0]) + Math.abs(p.c - stair[0][1]);
				p.d[1] = Math.abs(p.r - stair[1][0]) + Math.abs(p.c - stair[1][1]);
//				System.out.println(p.toString());
			}
			// 자료 가공 완료.
			
			// 필요한 변수 초기화
			peoplenum = people.size();
			int limit = (int) Math.pow(2, peoplenum+1);
			mintime = Integer.MAX_VALUE;
			
			// 비트로 모든 부분집합에 대해 계단 내려가보기 실행.
			for(int o = 0; o < limit; o++)
				downstair(o);
			
			sb.append("#" + t + " " + mintime + "\n");
		}
		System.out.print(sb);
	}
	public static void downstair(int bit) {
		int time = 0;
		int releasenum = 0;
		Queue<Integer>[] dist = new LinkedList[2];
		Queue<Integer>[] onstair = new LinkedList[2];
		int[] wait = new int[2];
		
		// dist가 0이 되면 dist에서 뽑고 계단에 올림. but, 계단이 포화면 그냥 dist에 둠.
		// 계단을 내려가는 것이, 이동보다 먼저 일어나야 함.
		for(int i = 0; i < 2; i++) {
			dist[i] = new LinkedList<>();
			onstair[i] = new LinkedList<>();
		}
		
		// 누가 어느 계단에 갈지 정하기.
		// bit에 있으면 1번출구로, 없으면 2번출구로.
		for(int b = 0; b < peoplenum; b++) {
			if((bit & 1<<b) > 0) dist[0].add(people.get(b).d[0]);
			else 	 			 dist[1].add(people.get(b).d[1]);
		}
		
		// 모든 사람이 계단을 다 내려가기 전까지 실행.
		while(releasenum < peoplenum) {
			time++;
			if(time >= mintime) return;
			
			// 계단 내려보내기.
			for(int i = 0; i < 2; i++) {
				int c = onstair[i].size();
				for(int p = 0; p < c; p++) {
					int loc = onstair[i].poll() - 1;
					
					if(loc < 0) releasenum++;
					else onstair[i].add(loc);
				}
			}
			
			// 계단으로 가기.
			for(int i = 0; i < 2; i++) {
				int c = dist[i].size();
				for(int p = 0; p < c; p++) {
					int loc = dist[i].poll() - 1;
					
					if(loc <= 0 && onstair[i].size() < 3) {
						if(loc == 0) onstair[i].add(stair[i][2]);
						else 		 onstair[i].add(stair[i][2] - 1);
					}
					else dist[i].add(loc);
				}
			}
			
			// 디버그
//			System.out.println(bit + " " + time);
//			System.out.println("1번 사람들 : " + dist[0]);
//			System.out.println("1번계단 : " + onstair[0] + " " + wait[0]);
//			System.out.println("2번 사람들 : " + dist[1]);
//			System.out.println("2번계단 : " + onstair[1] + " " + wait[1]);
//			System.out.println();
		}
		
//		if(mintime > time) System.out.println("====================================");
		mintime = Math.min(mintime, time);
	}
}

/*

1
5
0 1 1 0 0
0 0 1 0 3
0 1 0 1 0
0 0 0 0 0
1 0 5 0 0

1
6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
1 0 0 0 0 0
0 0 0 2 0 4

1
9
0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 8
7 0 0 0 0 1 0 0 0
0 0 0 0 0 1 1 0 0
0 0 0 0 0 0 0 0 0
1 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

1
5
0 0 0 0 2
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0
2 0 0 0 0

1
5
0 0 1 1 10
0 0 1 1 1
0 0 1 1 1
0 0 0 0 0
10 0 0 0 0

1
5
0 0 1 1 2
0 0 1 1 1
0 1 1 1 1
0 0 1 0 0
10 0 0 0 0

*/