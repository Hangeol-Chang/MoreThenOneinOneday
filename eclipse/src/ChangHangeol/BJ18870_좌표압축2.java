package ChangHangeol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BJ18870_좌표압축2 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pque = new PriorityQueue<>();
		HashMap<Integer, Integer> map = new HashMap<>();
    	
    	int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	nums[0] = Integer.parseInt(st.nextToken());
		pque.add(nums[0]);
    	for(int i = 1; i < n; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
			pque.add(nums[i]);
    	}
		//우선순위 큐로 정렬된 것을 어레이에 넣음.
		int poll = pque.poll();
		int i = 0;
		map.put(poll, i++);
		while(!pque.isEmpty()){
			int tmp = pque.poll();
			if(poll != tmp) {
				poll = tmp;
				map.put(poll, i++);
			}
		}
    	//제일 작은걸 0으로 잡고,
        //우선순위 큐에 입력된 값들을 다 넣고,(중복은 제거)
        //이를 인덱스로 찾아올 수 있게 변환하여~~

		for(int num : nums){
			bw.write(map.get(num) + " ");
		}
		bw.flush();
    }
}
