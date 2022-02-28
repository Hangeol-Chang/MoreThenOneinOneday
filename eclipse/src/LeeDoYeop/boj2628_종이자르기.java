package LeeDoYeop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class boj2628_종이자르기 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<Integer> row = new ArrayList<Integer>();
		List<Integer> col = new ArrayList<Integer>();
		int c = sc.nextInt();
		int r = sc.nextInt();
		int N = sc.nextInt();
		col.add(0);
		row.add(0);
		col.add(c);
		row.add(r);
		for (int i = 0; i < N; i++) {
			int direction = sc.nextInt();;
			if(direction == 0)
				row.add(sc.nextInt());
			else
				col.add(sc.nextInt());
		}
		Collections.sort(row);
		Collections.sort(col);
		int maxrow = 0;
		int maxcol = 0;
		for(int i = 0; i<row.size()-1; i++)
			maxrow = Math.max(maxrow, row.get(i+1)-row.get(i));
		for (int i = 0; i < col.size()-1; i++) 
			maxcol = Math.max(maxcol, col.get(i+1)-col.get(i));
		System.out.println(maxrow*maxcol);
	}
}
