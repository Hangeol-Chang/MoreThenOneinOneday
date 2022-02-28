package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2527_직사각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken());
			int y4 = Integer.parseInt(st.nextToken());
			if (x2 < x3 || y2 < y3 || x4 < x1 || y4 < y1)
				System.out.println("d");
			else if ((x2 == x3 && y2 == y3) || (x1 == x4 && y1 == y4) || (x2 == x3 && y1 == y4)
					|| (x1 == x4 && y2 == y3))
				System.out.println("c");
			else if ((y1 == y4) || (y2 == y3) || (x2 == x3) || (x1 == x4))
				System.out.println("b");
			else
				System.out.println("a");
		}
	}
}
