
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BJ1016_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] box = new int[n+1][];
		int maxx = 0;
		int maxy = 0;
		for(int i = 1; i <= n; i++) {
			box[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			maxx = Math.max(maxx, box[i][0] + box[i][2]);
			maxy = Math.max(maxy, box[i][1] + box[i][3]);
		}
		int[][] board = new int[maxx][maxy];
		int[] count = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			int limitx = box[i][0] + box[i][2];
			int limity = box[i][1] + box[i][3];
			
			for(int x = box[i][0]; x < limitx; x++) {
				for(int y = box[i][1]; y < limity; y++) {
					if(board[x][y] != 0) count[board[x][y]]--;
					board[x][y] = i;
					count[i]++;
				}
			}
		}
		for(int i = 1; i <= n; i++) System.out.println(count[i]);
	}
}
