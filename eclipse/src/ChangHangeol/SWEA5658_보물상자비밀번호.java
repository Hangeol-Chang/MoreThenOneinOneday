package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA5658_보물상자비밀번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			arr.clear();
			sb.append("#" + t + " ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String ref = br.readLine();
			StringBuilder nums = new StringBuilder();
			// 두번 붙여서 걍 이거 하나로 처리할 수 있게 함.
			nums.append(ref).append(ref);
			
			// 한 웅탱이의 자리수
			int cut = N/4;
			
			for(int p = 0; p < cut; p++) {				
				outer : for(int i = 0; i < 4; i++) {
					// 0~cut, cut~cut*2
					// cut*i ~ cut*(i+1)
					int stt = cut*i + p;
					int edd = (cut*(i+1) + p);
					int pow = cut;
					int sum = 0;
					for(int idx = stt; idx < edd; idx++) {
						int num = 0;
						char c = nums.charAt(idx);
						if(c >= 'A') num = c - 55;
						else num = c - 48;
						
						sum += num * Math.pow(16, --pow);
//						System.out.println(num + " " + pow + " " + sum);
					}
//					System.out.println(sum);
					// 중복 제거하고 집어넣기.
					for(int d = 0; d < arr.size(); d++) {
//						System.out.println(arr.get(d) + " " + sum);
						if(arr.get(d) == sum) continue outer;
					}
					arr.add(sum);
				}
			}
			// tmap에 입력하기 끝.
			// 맵에서 이 앞에까지 뽑고 출력.
			Collections.sort(arr, Collections.reverseOrder());
			sb.append(arr.get(K-1) + "\n");
		}
		System.out.println(sb);
	}
}
