import java.util.Scanner;

public class SWEA1926 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		for(int i = 1; i <= n; i++) {
			
			//i를 수정하지 않도록, 
			//p에 i를 헐당
			int p = i;
			
			//3의 배수이면 숫자를 출력하면 안되니.
			//이를 판단하기 위한 변수
			boolean is3in = false;
			
			//p에 3들어간 포함되는지를 확인하는 while문
			while(p > 0) {
				
				//10, 20 등 10의 배수를 거르기 위한 while문
				while(p % 10 == 0) p /= 10;
				
				//나온 수의 1의 자리에 369가 있는지 확인
				if((p % 10) % 3 == 0 ) { 
					System.out.print("-");
					
					//하나라도 출력되면, is3in을 true로 바꿈
					is3in = true;
				}
				//자릿수를 줄여가며 반복
				p /= 10;
			}
			
			//3의 배수가 하나도 없었다면, 숫자 출력
			if(!is3in) System.out.print(i);
			System.out.print(" ");
			in.close();
		}
	}
}
