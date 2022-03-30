package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BJ10989_수정렬하기3 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<Short, Integer> map = new TreeMap<>();
		int N = Integer.parseInt(br.readLine());
		
		short max = 0;
		for(int i = 0; i < N; i++) {
			short num = Short.parseShort(br.readLine());
			if(map.containsKey(num)) { map.put(num, map.get(num) +1); }
			else 					 { map.put(num, 1); }
			
			max = (short) Math.max(max, num);
		}
		for(short key : map.keySet()) {
			int num = map.get(key);
			while(num-- > 0) System.out.println(key);
		}
	}
}
