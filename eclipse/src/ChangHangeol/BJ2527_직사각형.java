package ChangHangeol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2527_직사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			if(p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) System.out.println("d");
			else {
				if(p1 == x2 || x1 == p2) {
					if(q1 == y2 || q2 == y1) System.out.println("c");
					else System.out.println("b");
				}
				else if(q1 == y2 || q2 == y1) {
					if(p1 == x2 || p2 == x1) System.out.println("c");
					else System.out.println("b");
				}
				else System.out.println("a");
			}
			
		}
	}
}
/*
10 10 50 50 10 10 40 50


*/