
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13300_방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//0이 여자
		//1이 남자
		int[][] students = new int[2][6];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			students[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())-1]++;
		}
		int room = 0;
		for(int i = 0; i < 12; i++) {
			// 각 학년 학생들의 위치 students[i%6][i/6];
			room += students[i/6][i%6] / k;
			if(students[i/6][i%6] % k != 0) room++;
		}
		System.out.println(room);
	}
}
