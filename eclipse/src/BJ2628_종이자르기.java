import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ2628_종이자르기 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> rowcut = new ArrayList<>();
		ArrayList<Integer> colcut = new ArrayList<>();
		rowcut.add(0);
		colcut.add(0);
		colcut.add(in.nextInt());	//가로에 추가
		rowcut.add(in.nextInt());	//세로에 추가
		
		int n = in.nextInt();
		
		for(int t = 0; t < n; t++) {
			int dir = in.nextInt();
			int loc = in.nextInt();
			
			switch (dir) {
			case 0:
				rowcut.add(loc);
				break;
			case 1:
				colcut.add(loc);
				break;
			}
		}
		Collections.sort(rowcut);
		Collections.sort(colcut);
		int rowcutsize = rowcut.size();
		int colcutsize = colcut.size();

		int rowmax = 0;
		int colmax = 0;

		//차를 구함
		for(int i = 1; i < rowcutsize; i++) {
			int tmp = rowcut.get(i) - rowcut.get(i-1);
			if(tmp > rowmax) rowmax = tmp;
		}
		for(int i = 1; i < colcutsize; i++) {
			int tmp = colcut.get(i) - colcut.get(i-1);
			if(tmp > colmax) colmax = tmp;
		}
		System.out.println(colmax * rowmax);
	}
}
