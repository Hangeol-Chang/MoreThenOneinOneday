package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2342_DDR {
	static class person {
		int l, r;
		int cost;
		person(int l, int r, int cost) {
			this.l = l;
			this.r = r;
			this.cost = cost;
		}
//		@Override
//		public String toString() {
//			return "person [l=" + l + ", r=" + r + ", cost=" + cost + "]";
//		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 이번꺼를 왼쪽발로 누를 때, 오른쪽 걸로 누를 때 나눠서 dp
		person[][] ddr = new person[2][2];
		ddr[0][0] = new person(0, 0, 0);
		ddr[0][1] = new person(0, 0, 0);
		
		while(true) {
			int a = Integer.parseInt(st.nextToken());
			if(a == 0) break;
			
			for(int i = 0; i < 2; i++) {
				int cost1 = push(ddr[0][0], i, a);
				int cost2 = push(ddr[0][1], i, a);
				
				if(i == 0) {
					if(cost1 < cost2) { ddr[1][i] = new person(a, ddr[0][0].r, ddr[0][0].cost + cost1); }
					else 			  { ddr[1][i] = new person(a, ddr[0][1].r, ddr[0][1].cost + cost2); }					
				}
				else {
					if(cost1 < cost2) { ddr[1][i] = new person(ddr[0][0].l, a, ddr[0][0].cost + cost1); }
					else 			  { ddr[1][i] = new person(ddr[0][1].l, a, ddr[0][1].cost + cost2); }					
				}
			}
			ddr[0][0] = ddr[1][0];
			ddr[0][1] = ddr[1][1];
//			System.out.println("===");
//			System.out.println(0 + " " + ddr[0][0].toString());
//			System.out.println(1 + " " + ddr[0][1].toString());
		}
		System.out.print(Math.min(ddr[0][0].cost, ddr[0][1].cost));
	}
	// foot : 0이 왼발, 1이 오른발
	static int push(person p, int foot, int press) {
		int loc = 0;
		int cost = 0;
		
		if(foot == 0) {
			loc = p.l;
			if(p.r == press) return 5;
		}
		else {
			loc = p.r;
			if(p.l == press) return 5;
		}
		
		if(loc == 0) cost = 2;
		else if ( loc == press ) cost = 1;
		else if ( Math.abs(loc - press) == 2) cost = 4;
		else cost = 3;
		
		return cost;
	}
}
