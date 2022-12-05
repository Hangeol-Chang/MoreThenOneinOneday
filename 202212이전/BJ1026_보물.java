

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1026_보물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> aq = new PriorityQueue<>();
		PriorityQueue<Integer> bq = new PriorityQueue<>(Collections.reverseOrder());
		
		StringTokenizer sta = new StringTokenizer(br.readLine());
		StringTokenizer stb = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			aq.add(Integer.parseInt(sta.nextToken()));
			bq.add(Integer.parseInt(stb.nextToken()));
		}
		int sum = 0;
		for(int i = 0; i < N; i++)
			sum += aq.poll() * bq.poll();
		
		System.out.println(sum);
	}
}
