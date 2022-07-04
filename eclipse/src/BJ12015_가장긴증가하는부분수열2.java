import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;
/*
 * duelLinkedlist 형태의 priorityque를 강제 구현하여,
 */
public class BJ12015_가장긴증가하는부분수열2 {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] res = new int[n];
        ArrayList<Integer> save = new ArrayList<>();
        save.add(0);
        
        // n까지 올라가는 동안 반복.
        for(int i = 0; i < n; i++) {
        	
        	int savesize = save.size();
        	int j = 0;
        	while(j < savesize) {
        		if(save.get(j) > nums[i]) break;
        		j++;
        	}
        	
        	// 대입하기
        	if(j == savesize)	save.add(nums[i]);
        	else				save.set(j, nums[i]);
        	res[i] = j;
        }
        System.out.println(res[n-1]);
    }
}
