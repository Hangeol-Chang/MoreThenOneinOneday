

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_문제출제대회_나보다나은우리 {
	static int N;
	static String[] refs;
	static String ans;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 1; t++) {
			N = Integer.parseInt(br.readLine());
			ans = br.readLine();
			result = 0;
			
			refs = new String[N];
			for(int i = 0; i < N; i++) refs[i] = br.readLine();
			// 빈 줄 지우기
			br.readLine();
			// 입력 완료.
			
			for(int i = 1; i <= N; i++) {
				if(result == 0) sel(i, 0, 0, new int[i]);
			}
			sb.append((result == 0 ? -1 : result) + "\n");
		}
		System.out.print(sb);
	}
	// 뽑을 수, 뽑은 수, 현재 판단 위치, 뽑힌 애들
	static void sel(int goalnum, int sel, int idx, int[] selected) {
		if(goalnum == sel) {
			// 선택이 완료됨.
			checkans(selected);
			return;
		}
		if(idx >= N || result != 0) return;
		
		for(int i = idx; i < N; i++) {
			
			selected[sel] = i;
			sel(goalnum, sel+1, i+1, selected);
		}
	}
	static void checkans(int[] selected) {
		int len = ans.length();
		
		loc : for(int l = 0; l < len; l++) {
			// l번째 위치에 답을 만들 수 있는지 확인.
			char a = ans.charAt(l);
			
			for(int sel : selected)
				if (refs[sel].charAt(l) == a)
					continue loc;
			
			// 여기에 도착하면 실패.
			return;
		}
		// 여기에 도착하면 만들어진 것.
		result = selected.length;
	}
}
