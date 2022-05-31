package Making;

public class TestcaseMaker {
	public static void main(String[] args) {
		int T = 50;
		System.out.println(T);
		
		for(int t = 1; t <= T; t++) {
			int n = randN();
			int k = randK(n);
			int b = randB(n);
			
			System.out.println(n + " " + k + " " + b);
			
			for(int i = 0; i < n; i++)
				System.out.print(randSize() + " ");
			System.out.println();
		}
	}
	public static int randN() {
		return (int)(Math.random()*(40-1) + 1);
	}
	public static int randK(int n) {
		return (int)(Math.random()*(n-1) + 1);
	}
	public static int randB(int n) {
		return (int)(Math.random()*(1000-n) + n);
	}
	public static int randSize() {
		return (int)(Math.random()*100);
	}
}
