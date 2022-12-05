
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * 배열을 가지고 재귀함수에 들어감.
 * 만약 배열을 분할해야 하면,
 * 4등분한 배열을 가지고 재ㅐ귀에 들어감.
 * 
 * 각 함수는 흰색, 파란색 종이로 완전 나눠지면, 그 수를 스태틱 변수에 더함.
 */
public class BJ2630_색종이만들기 {
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[][] paper = new int[n][];
    	
    	for(int i = 0; i < n; i++) {
    		paper[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    	}
    	cutting(paper, 0, 0, n, n);
    	System.out.printf("%d\n%d", white, blue);
    }
    
    public static void cutting(int[][] paper, int sty, int stx, int edy, int edx){
        int wb = paper[sty][stx];
        for(int y = sty; y < edy; y++) {
        	for(int x = stx; x < edx; x++)
        		if(wb != paper[y][x]) {
        			cutting(paper, sty, 		stx, 		 (sty+edy)/2, (stx+edx)/2);		//1
        			cutting(paper, sty, 		(stx+edx)/2, (sty+edy)/2, edx  		 );		//2
        			cutting(paper, (sty+edy)/2, stx, 		 edy, 		  (stx+edx)/2);		//3
        			cutting(paper, (sty+edy)/2, (stx+edx)/2, edy, 		  edx		 );		//4
        			return;
        		}
        }
        if(wb == 1) blue++;
        else 		white++;
    }
}