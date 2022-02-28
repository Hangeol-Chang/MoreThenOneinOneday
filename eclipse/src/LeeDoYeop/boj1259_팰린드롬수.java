package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1259_팰린드롬수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (;;) {
			char[] check = br.readLine().toCharArray();
			if (check[0] == '0')
				break;
			else {
				String str = "yes";
				for (int i = 0; i < check.length / 2; i++) {
					if (check[i] == check[check.length - i - 1])
						str = "yes";
					else {
						str = "no";
						break;
					}
				}
				System.out.println(str);
			}
		}
	}
}
