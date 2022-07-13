import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2754_학점계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ini = br.readLine();
		
		float a = 0.0f;
		switch (ini.charAt(0)) {
		case 'A' :
			a = 4.0f;
			break;
		case 'B' :
			a = 3.0f;
			break;
		case 'C' :
			a = 2.0f;
			break;
		case 'D' :
			a = 1.0f;
			break;
		case 'F' :
			System.out.println("0.0");
			return;
		}
		
		switch(ini.charAt(1)) {
		case '+' :
			a += 0.3f;
			break;
		case '-' :
			a -= 0.3;
			break;
		}
		
		System.out.printf("%.1f", a);
	}
}
