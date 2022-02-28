package ChangHangeol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1230_암호문3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st;
		
		int T = 10;
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			//토크나이저로 리스트 입력 받기.
			LinkedList<String> li = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) { li.add(st.nextToken()); }
			//기본 입력 끝.
			
			//명령 수
			int ordernum = Integer.parseInt(br.readLine());
			//명령들을 다 끌어온 토크나이져
			st = new StringTokenizer(br.readLine());
			//명령수만큼 반복.
			int x = 0;
			int y = 0;
			for(int i = 0; i < ordernum; i++) {
				String order = st.nextToken();
				
				switch(order) {
				case "I" :
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					
					//x번부터 순서대로 추가해감.
					for (int j = 0; j < y; j++) li.add(x++, st.nextToken());
					break;
					
				case "D" :
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					
					//x번째를 계속 지움.
					for(int j = 0; j < y; j++) li.remove(x);
					break;
					
				case "A" :
					y = Integer.parseInt(st.nextToken());
					
					//그냥 애드
					for(int j = 0; j < y; j++) li.add(st.nextToken());
					break;
				}
			}
			
			//스트링빌더에 더하기
			sb.append("#" + t);
			for(int i = 0; i < 10; i++) sb.append(" " + li.get(i));
			sb.append("\n");
//			System.out.println(sb);
//			System.out.println();
		}
		System.out.println(sb);
	}
}
