package ChangHangeol;

public class test {
	// sel[] : 해당 원소 포함 여부 저장
	// n : 원소의 개수
	// k : 현재 depth

	static int[] nums = {1, 2, 3, 4};
	static boolean[] sel = new boolean[4];
	static int n = 4;
	static int k = 2;
	public static void main(String[] args){
	    powerset(n, 0);
	}

	static void powerset(int n, int k) {
	    if(k > n) return;
		if(n == k) {
	        System.out.print("[ ");
	        for(int i = 0; i < n; i++)
	            if(sel[i]) 
	                System.out.print(nums[i] + " ");
			System.out.println("] ");
	        return;
	    }
	    sel[k] = false;
	    powerset(n, k+1);
	    
	    sel[k] = true;
	    powerset(n, k+1);
	}
}
