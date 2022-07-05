import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

public class BJ14003_가장긴증가하는부분수열5 {
	public static class node {
		int data;
		ArrayList<Integer> path;
		node(int data, ArrayList<Integer> path) {
			this.data = data;
			this.path = path;
		}
	}

	static ArrayList<node> save = new ArrayList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        save.add(new node(Integer.MIN_VALUE, new ArrayList<>()));

        int max = 0;
        // n까지 올라가는 동안 반복.
        for(int i = 0; i < n; i++) {
        	
        	int savesize = save.size();
        	
        	// lowerbound로 찾아오기.
        	int j = binarysearch(0, save.size(), nums[i]);
        	
        	// 대입하기
			ArrayList<Integer> path = (ArrayList<Integer>) save.get(j-1).path.clone();
			path.add(nums[i]);

			if(j == savesize) save.add(new node(nums[i], path));
        	else 			  save.set(j, new node(nums[i], path));

        	max = Math.max(j,  max);
        	
//        	for(int k = 0; k < save.size(); k++) { 
//        		System.out.println(k + " " + save.get(k));
//        	}
//        	System.out.println(i + "번째 사이클 종료\n");
        }
		StringBuilder sb = new StringBuilder();
		sb.append(max + "\n");
		ArrayList<Integer> ans = save.get(max).path;
		for(int i = 0; i < max; i++) sb.append(ans.get(i) + " ");
		System.out.print(sb);
    }
    
    public static int binarysearch(int st, int ed, int val) {
    	while(st < ed) {
    		int md = (st + ed)/2;
    		int chk = save.get(md).data;
    		if(chk < val) st = md+1;
    		else		  ed = md;
    	}
    	
    	return st;
    }
}

/*

24
1 2 4 5 8 10 51 1 5 4 7 2 6 8 4 6 41 411 855 74 6 88 100 20


*/