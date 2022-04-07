package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 세로로 찍어서 동일한 특성이 K개 연속이면 통과
// 한 줄을 통째로 A or B로 바꿀 수 있음.
public class SWEA2112_보호필름 {
	static int[] mak;
	// 0번 인덱스에 다 0인걸 저장, 1번에 다 1인걸 저장.
	static int maxin;
	static int D, W, K;
	static int mind;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++){
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			maxin = (int) (Math.pow(2, W)-1);
			K = Integer.parseInt(st.nextToken());
			mind = K;
			
			mak = new int[D];
			for(int i = 0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<W; j++)
					if(st.nextToken().equals("1"))
						mak[i] = mak[i] | 1<<j;
			}
			// 입력 끝.
			// 각각의 1<<i가 있는지 없는지 확인하면 됨. (num1 & 1<<i) == (num2 & 1<<i)
			run(0, 0);
			sb.append("#" + t + " " + mind + "\n");
		}
		System.out.println(sb);
	}
	public static void run(int count, int idx) {
		// 백트래킹
		if(count >= mind) return;
		// 싹 돌면서 검사해서
		
//		for(int i = 0; i < D; i++) {
//			for(int j = 0; j < W; j++) {
//				System.out.print(((mak[i] & 1<<j) == 0) ? 0 + " " : 1 + " ");
//			}
//			System.out.println();
//		}
		
		boolean can = true;
		outer : for(int w = 0; w < W; w++){
			for(int d = 0; d < D-K+1; d++) {
				for(int k = 0; k < K; k++) {
					// 연속되게 패널이 나열되어 있으면 계속.
					if((mak[d] & 1<<w) == (mak[d+k] & 1<<w)) {
						// 다통과했으면 내보내기.
						if(k == K-1) {
//							System.out.println(w + " " + d + ", count : " + count);
							continue outer;
						}
						// 아직 통과중이면 다음꺼 실행.
						continue;
					}
					// 연속되지 않으면 다음 d에 대해 체크.
					else break;
				} // 한 d에 대한 검사문.
			}
			// 여기에 오는거 자체가 실패
			can = false;
//			System.out.println("fail");
			break;
		}
//		System.out.println();
		
		// 통과하면 mind랑 비교해서 최솟값 넣기.
		if(can) {
			mind = Math.min(mind, count);
			return;
		}
		// 통과 못했을 때, 더 할 수 있는게 없으면 리턴.
		else if(idx >= D) return;
		// 통과 못하면 그냥 넘겨보거나 두가지로 나눠서 바꿔넘겨보기
		else {
			// 나를 안바꾸고 다음으로 넘기기
			run(count, idx+1);
			
			// 다 빈걸로 바꾼 뒤 돌려보기
			int tmp = insert(0, idx);
			run(count+1, idx+1);
			
			// 다 찬걸로 바꾼 뒤 돌려보기
			insert(maxin, idx);
			run(count+1, idx+1);
			
			// 원상복구
			mak[idx] = tmp;
		}
		
	}
	public static int insert(int num, int idx) {
		int tmp = mak[idx];
		mak[idx] = num;
		return tmp;
	}
}

/*

1
13 20 12
1 1 0 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 0 0
1 1 1 1 0 1 0 1 0 0 0 0 1 0 0 0 0 1 0 0
1 0 1 0 1 1 0 1 0 1 1 0 0 0 0 1 1 0 1 0
0 0 1 1 0 1 1 0 1 0 0 1 1 0 0 0 1 1 1 1
0 0 1 0 0 1 0 0 1 0 0 0 0 1 0 0 0 0 1 1
0 0 1 0 0 0 0 0 0 0 0 0 1 1 1 0 0 1 0 1
0 0 0 1 0 0 0 0 0 0 1 1 0 0 0 1 0 0 1 0
1 1 1 0 0 0 1 0 0 1 1 1 0 1 0 1 0 0 1 1
0 1 1 1 1 0 0 0 1 1 0 1 0 0 0 0 1 0 0 1
0 0 0 0 1 0 1 0 0 0 1 0 0 0 0 1 1 1 1 1
0 1 0 0 1 1 0 0 1 0 0 0 0 1 0 1 0 0 1 0
0 0 1 1 0 0 1 0 0 0 1 0 1 1 0 1 1 1 0 0
0 0 0 1 0 0 1 0 0 0 1 0 1 1 0 0 1 0 1 0

1
5 5 1
0 1 0 1 0
1 1 0 0 1
1 0 1 1 1
1 1 1 1 1
1 0 0 0 0

1
5 5 5
1 0 0 0 0
1 0 0 0 0
1 0 0 0 0
1 0 0 0 0
1 0 0 0 0

1
6 1 6
0
1
0
0
0
1

1
10 1 10
0
1
0
1
0
0
0
0
1
1

1
5 5 5
0 1 0 1 0
1 0 1 0 1
0 1 0 1 0
1 0 1 0 1
0 1 0 1 0

1
5 5 3
0 0 0 0 0
0 0 0 0 0
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1

1
5 5 4
0 0 0 0 0
0 0 0 0 0
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1

1
5 5 5
1 0 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 0 1

1
6 8 4
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1

1
6 8 3
0 0 1 0 1 0 0 1
0 1 0 0 0 1 1 1
0 1 1 1 0 0 0 0
1 1 1 1 0 0 0 1
0 1 1 0 1 0 0 1
1 0 1 0 1 1 0 1

1
6 8 3
0 0 1 0 1 0 0 1
0 0 0 0 0 0 0 0
0 1 1 1 0 0 0 0
1 1 1 1 0 0 0 1
1 1 1 1 1 1 1 1
1 0 1 0 1 1 0 1

1
6 8 3
1 1 1 1 0 0 1 0
0 0 1 1 0 1 0 1
1 1 1 1 0 0 1 0
1 1 1 0 0 1 1 0
1 1 0 1 1 1 1 0
1 1 1 0 0 1 1 0

1
6 8 4
1 1 0 0 0 1 1 0
1 0 1 0 0 1 1 1
0 1 0 0 1 1 0 0
1 0 1 0 0 0 0 0
1 1 0 0 0 0 0 0
1 0 0 0 1 1 1 1

1
6 4 4
1 1 0 0
0 1 0 1
0 0 0 1
1 1 1 1
1 1 0 1
1 0 1 0
*/