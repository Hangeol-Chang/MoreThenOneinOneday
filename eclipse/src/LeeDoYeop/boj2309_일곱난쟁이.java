package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj2309_일곱난쟁이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			int num = Integer.parseInt(br.readLine());
			list.add(num);
			sum += num;
		}
		Collections.sort(list);
		outer: for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - list.get(i) - list.get(j) == 100) {
					list.remove(i);
					list.remove(j - 1);
					break outer;
				}
			}
		}
		for (int i = 0; i < 7; i++)
			sb.append(list.get(i)).append("\n");
		System.out.println(sb.toString());
	}
}
