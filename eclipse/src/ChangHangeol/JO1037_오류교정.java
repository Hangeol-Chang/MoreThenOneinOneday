import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class JO1037_오류교정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] data = new int[n][];
		for(int i = 0; i < n; i++)
			data[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		//입력받기 끝.

		int[] rsum = new int[n];
		int[] csum = new int[n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				rsum[i] += data[i][j];
				csum[j] += data[i][j];
			}
		}

		int roddcount = 0;
		int coddcount = 0;
		int roddidx = 0;
		int coddidx = 0;

		for(int i = 0; i < n; i++){
			if(rsum[i] % 2 != 0){
				roddidx = i;
				roddcount++; 
			}
			if(csum[i] % 2 != 0){
				coddidx = i;
				coddcount++; 
			}
		}
		
		if(roddcount + coddcount == 0) System.out.println("OK");
		else if(roddcount == 1 && coddcount == 1) System.out.println("Change bit (" + (roddidx+1) + "," + (coddidx+1) + ")");
		else System.out.println("Corrupt");
	}
}
