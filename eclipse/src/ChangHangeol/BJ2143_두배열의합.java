package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

// 이분탐색으로 다시 풀어볼 것.
public class BJ2143_두배열의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		long[] a = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		int m = Integer.parseInt(br.readLine());
		long[] b = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		// 입력 끝.
		
		ArrayList<Long> apsum = new ArrayList<>();
		ArrayList<Long> bpsum = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			long tmpsum = 0;
			for(int j = i; j < n; j++) {
				tmpsum += a[j];
				apsum.add(tmpsum);
			}
		}
		for(int i = 0; i < m; i++) {
			long tmpsum = 0;
			for(int j = i; j < m; j++) {
				tmpsum += b[j];
				bpsum.add(tmpsum);
			}
		}
		// 데이터 정리 완료.
		
		apsum.sort(null);
		bpsum.sort(Collections.reverseOrder());
		
//		System.out.println(apsum);
//		System.out.println(bpsum);
		
		long ans = 0;
		int ap = 0;
		int bp = 0;
		while(ap < apsum.size() && bp < bpsum.size()) {
			long sum = apsum.get(ap) + bpsum.get(bp);
			
			// 합이 T보다 크면 b쪽을 올리기
			if(sum > T) {
				long idf = bpsum.get(bp);
				while(bp < bpsum.size() && idf == bpsum.get(bp)) bp++;
			}
			// 합이 T보다 작으면 a쪽을 올리기
			else if(sum < T) {
				long idf = apsum.get(ap);
				while(ap < apsum.size() && idf == apsum.get(ap)) ap++;
			}
			else {
				long acount = 0;
				long aidf = apsum.get(ap);
				while(ap < apsum.size() && aidf == apsum.get(ap)) {
					acount++;
					ap++;
				}
				long bcount = 0;
				long bidf = bpsum.get(bp);
				while(bp < bpsum.size() && bidf == bpsum.get(bp)) {
					bcount++;
					bp++;
				}
				ans += acount * bcount;
			}
		}
		System.out.print(ans);
	}
}
