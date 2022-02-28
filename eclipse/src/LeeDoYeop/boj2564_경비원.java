package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2564_경비원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[H + 1][W + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int direction = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			switch (direction) {
			case 1:
				arr[0][idx] = i;
				break;
			case 2:
				arr[H][idx] = i;
				break;
			case 3:
				arr[idx][0] = i;
				break;
			case 4:
				arr[idx][W] = i;
				break;
			}
		}
		int rIdx = 0;
		int cIdx = 0;
		st = new StringTokenizer(br.readLine(), " ");
		int direction = Integer.parseInt(st.nextToken());
		int idx = Integer.parseInt(st.nextToken());
		switch (direction) {
		case 1:
			cIdx = idx;
			break;
		case 2:
			rIdx = H;
			cIdx = idx;
			break;
		case 3:
			rIdx = idx;
			break;
		case 4:
			rIdx = idx;
			cIdx = W;
			break;
		}
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			int r2Idx = 0;
			int c2Idx = 0;
			int min = 200;
			for (int r = 1; r < H; r++) {
				if (arr[r][0] == i) {
					r2Idx = r;
					break;
				}
				if (arr[r][W] == i) {
					r2Idx = r;
					c2Idx = W;
					break;
				}
			}
			for (int c = 1; c < W; c++) {
				if (arr[0][c] == i) {
					c2Idx = c;
					break;
				}
				if (arr[H][c] == i) {
					c2Idx = c;
					r2Idx = H;
					break;
				}
			}
			switch (direction) {
			case 1:
				if (c2Idx == 0) {
					min = r2Idx + cIdx;
					break;
				} else if (c2Idx == W) {
					min = r2Idx + W - cIdx;
					break;
				} else if (r2Idx == 0) {
					min = Math.abs(c2Idx - cIdx);
					break;
				} else {
					min = H + Math.min(cIdx + c2Idx, (W - cIdx) + (W - c2Idx));
					break;
				}
			case 2:
				if (c2Idx == 0) {
					min = H - r2Idx + cIdx;
					break;
				} else if (c2Idx == W) {
					min = H - r2Idx + W - cIdx;
					break;
				} else if (r2Idx == 0) {
					min = H + Math.min(cIdx + c2Idx, (W - cIdx) + (W - c2Idx));
					break;
				} else if (r2Idx == H) {
					min = Math.abs(c2Idx - cIdx);
					break;
				}
			case 3:
				if (c2Idx == 0) {
					min = Math.abs(r2Idx - rIdx);
					break;
				} else if (c2Idx == W) {
					min = W + Math.min(rIdx + r2Idx, (H - rIdx) + (H - r2Idx));
					break;
				} else if (r2Idx == 0) {
					min = rIdx + c2Idx;
					break;
				} else {
					min = H - rIdx + c2Idx;
					break;
				}
			case 4:
				if (c2Idx == 0) {
					min = W + Math.min(rIdx + r2Idx, (H - rIdx) + (H - r2Idx));
					break;
				} else if (c2Idx == W) {
					min = Math.abs(r2Idx - rIdx);
					break;
				} else if (r2Idx == 0) {
					min = rIdx + W - c2Idx;
					break;
				} else {
					min = H - rIdx + W - c2Idx;
					break;
				}
			}
			sum += min;
		}
		System.out.println(sum);
	}
}
