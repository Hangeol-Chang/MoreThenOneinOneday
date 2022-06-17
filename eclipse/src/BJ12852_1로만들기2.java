

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ12852_1로만들기2 {
	static class data {
		ArrayList<Integer> path;
		int count;
		data(int count) {
			this.count = count;
			this.path = new ArrayList<>();
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		data[] arr = new data[n+1];
		
		arr[n] = new data(0);
		arr[n].path.add(n);
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(n);
		while(arr[1] == null) {
			int now = que.poll();
			
			for(int idf = 2; idf <= 3; idf++) {
				if(now%idf == 0 && arr[now/idf] == null) {
					arr[now/idf] = new data(arr[now].count+1);
					arr[now/idf].path.addAll(arr[now].path);
					arr[now/idf].path.add(now/idf);
					que.add(now/idf);
				}
				if(arr[now-1] == null) {
					arr[now-1] = new data(arr[now].count+1);
					arr[now-1].path.addAll(arr[now].path);
					arr[now-1].path.add(now-1);
					que.add(now-1);
				}
			}
		}
		System.out.println(arr[1].count);
		for(int num : arr[1].path)
			System.out.print(num + " ");		
	}
}
