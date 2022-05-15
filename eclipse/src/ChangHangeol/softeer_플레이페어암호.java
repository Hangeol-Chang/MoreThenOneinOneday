package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class softeer_플레이페어암호 {
	static int[] enc = new int[25];
	static ArrayList<String> module = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg = br.readLine();
		String key = br.readLine();
		
		Arrays.fill(enc, -1);
		int idx = 0;
		for(int i = 0; i < key.length(); i++) {
			int loc = key.charAt(i) - ( key.charAt(i)  > 73 ? 'B' : 'A' );
			if(enc[loc] == -1) enc[loc] = idx++;
		}
		for(int i = 0; i < 25; i++) 
			if(enc[i] == -1) enc[i] = idx++;
		// 암호화 표 생성 완료.
		
		// 메세지 정리
		for(int i = 1; i < msg.length(); i = i+2) {
			if(msg.charAt(i-1) == msg.charAt(i)) {
				char insert = 'X';
				if(msg.charAt(i-1) == 'X') insert = 'Q';
				msg = msg.substring(0, i) + insert + msg.substring(i);	
			}
		}
		if(msg.length() % 2 != 0) msg += 'X';
		
		for(int i = 0; i < msg.length(); i = i+2)
			module.add(msg.substring(i, i+2));
		// 데이터 정리 완료
		
		StringBuilder ans = new StringBuilder();
		for(String ref : module){
			// 두 문자를 수로 가져옴.
			int a = ref.charAt(0) - ( ref.charAt(0)  > 73 ? 'B' : 'A' );
			int b = ref.charAt(1) - ( ref.charAt(1)  > 73 ? 'B' : 'A' );
			
			// 행이 같을 때.
			int aa, bb = 0;
			if(enc[a]/5 == enc[b]/5) {
				aa = (enc[a]+1)%5 + (enc[a]/5)*5;
				bb = (enc[b]+1)%5 + (enc[b]/5)*5;
//				System.out.println("행이 같음");
			}
			// 열이 같을 때.
			else if(enc[a]%5 == enc[b]%5) {
				aa = (enc[a]+5)%25;
				bb = (enc[b]+5)%25;
//				System.out.println("열이 같음");
			}
			// 둘 다 다를 때.
			else {
				aa = (enc[a]/5)*5 + enc[b]%5;
				bb = (enc[b]/5)*5 + enc[a]%5;
//				System.out.println("다름");
			}
//			System.out.println(enc[a] + " " + enc[b] + ", " + aa + " " + bb + " " + ref);
			ans.append(getchar(aa));
			ans.append(getchar(bb));
		}
		System.out.println(ans);
	}
	public static char getchar(int target) {
		for(int i = 0; i < 25; i++) {
			int v = enc[i];					
			if(v == target)
				return (char) (i + (i > 8 ? 66 : 65));
		}
		return 0;
	}
}

/*
01234
56789

01234 56789 01234
ABCDE FGHIK LMNOP
65


*/