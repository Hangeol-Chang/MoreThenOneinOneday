
/*
 * 메모리 초과.
 * 
 * 함수가 실행되야 하는 횟수를 저장해서,
 * start위치에서 함수를 타고 들어가면서, 그 위치부터 출력해 나오기.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1055_끝이없음 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String ref = br.readLine();
		String arr = br.readLine();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int len = 0;
		int count = 0;
		while(len < end && count < n) {
			len = 0;
			StringBuilder tmp = new StringBuilder();
			for(int i = 0; i < arr.length(); i++) {
				char tmpchar = arr.charAt(i);

				if(tmpchar == '$') {
					tmp.append(ref);
					len += ref.length();
				}
				else {
					tmp.append(tmpchar);
					len++;
				}
			}
			ref = tmp.toString();
			count++;
//			System.out.println(ref);
//			System.out.println();
		}
		if(end < ref.length()) System.out.print(ref.substring(start-1, end));
		else {
			 System.out.print(ref.substring(start-1, ref.length()));
			 for(int i = arr.length()+1; i < end-1; i++) {
				 System.out.print('-');
			 }
		}
	}
}