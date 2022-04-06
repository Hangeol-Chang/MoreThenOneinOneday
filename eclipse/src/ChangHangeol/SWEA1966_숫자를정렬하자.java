package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class SWEA1966_숫자를정렬하자 {
	static int[] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t);
			int N = Integer.parseInt(br.readLine());
			map = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			sort(0, map.length-1);
			for(int m : map) { sb.append(" " + m); }
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void sort(int left, int right) {
		if(!(left < right)) return;
		
		int pivot = map[left];
		
		int iter1 = left+1;
		int iter2 = right;
		
		while(iter1 <= iter2) {
			while(iter1 <= iter2 && map[iter1] <= pivot) iter1++;
			while(					map[iter2] >  pivot) iter2--;
			
			if(iter1 < iter2) {
				int tmp = map[iter1];
				map[iter1] = map[iter2];
				map[iter2] = tmp;
			}
		}
		map[left] = map[iter2];
		map[iter2] = pivot;
		
		pivot = iter2;
		sort(left, pivot-1);
		sort(pivot+1, right);
	}
}
