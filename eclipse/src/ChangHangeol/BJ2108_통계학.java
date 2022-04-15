package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ2108_통계학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] freq = new int[8001];
		int maxfreq = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int num = Integer.parseInt(br.readLine());
		long sum = num;
		int max = num;
		int min = num;
		freq[num+4000] = 1;
		
		for(int i = 1; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			sum += num;
			if(max < num) max = num;
			else if(min > num) min = num;
			
			if(++freq[num+4000] > maxfreq) maxfreq = freq[num+4000];
		}
		
		int idx = 0;
		int count = -1;
		int mid = 0;
		boolean c = false;
		for(int nd : freq) {
			if(nd == maxfreq) pq.add(idx-4000);
			count += nd;
			if(!c && count >= N/2) {
				mid = idx-4000;
				c = true;
			}
			idx++;
		}
		if(pq.size() > 1) pq.poll();
		double avg = Math.round(1.0*sum/N);
		
		StringBuilder sb = new StringBuilder();
		sb.append((int)avg + "\n");
		sb.append(mid + "\n");
		sb.append(pq.poll()+ "\n");
		sb.append((max - min) + "\n");
		
		System.out.println(sb);
	}
}
