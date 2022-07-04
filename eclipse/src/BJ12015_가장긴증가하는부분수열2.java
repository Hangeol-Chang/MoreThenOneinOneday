import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

public class BJ12015_가장긴증가하는부분수열2 {
	static ArrayList<Integer> save = new ArrayList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        save.add(0);
        
        int max = 0;
        // n까지 올라가는 동안 반복.
        for(int i = 0; i < n; i++) {
        	
        	int savesize = save.size();
        	
        	// lowerbound로 찾아오기.
        	int j = binarysearch(0, save.size(), nums[i]);
        	
        	// 대입하기
        	if(j == savesize)	save.add(nums[i]);
        	else				save.set(j, nums[i]);
        	max = Math.max(j,  max);
        	
//        	for(int k = 0; k < save.size(); k++) {
//        		System.out.println(k + " " + save.get(k));
//        	}
//        	System.out.println(i + "번째 사이클 종료\n");
        }
        System.out.println(max);
    }
    
    public static int binarysearch(int st, int ed, int val) {
    	
    	int md;
    	while(st < ed) {
    		md = (st + ed)/2;
    		int chk = save.get(md);
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