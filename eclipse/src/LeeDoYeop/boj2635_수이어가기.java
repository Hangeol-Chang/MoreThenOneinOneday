package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj2635_수이어가기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int a = 0;
		int max = 3;
		int save = 0;
		int idx = 0;
		for(int i = n/2; i<=n; i++) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(n);
			list.add(i);
			idx = 0;
			while(true) {
				a = list.get(idx) - list.get(idx+1);
				if(a<0)
					break;
				list.add(a);
				idx++;
			}
			if(max < list.size()) {
				save = i;
				max = list.size(); 
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(n);
		list.add(save);
		idx = 0;
		while(true) {
			a = list.get(idx) - list.get(idx+1);
			if(a<0)
				break;
			list.add(a);
			idx++;
		}
		sb.append(max).append("\n");
		for(int i = 0; i< max; i++)
			sb.append(list.get(i)).append(" ");
		System.out.println(sb);
	}
}
