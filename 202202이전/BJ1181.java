//시간초과
//인덱스에러

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BJ1181 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		in.nextLine();

		List<String> word_v = new ArrayList<>();
//		int[] iter = new int[n];

		for (int i = 0; i < n; i++)
			word_v.add(in.nextLine());
		in.close();
		List<String> word = word_v.stream().distinct().collect(Collectors.toList());
		n = word.size();

		word.sort(Comparator.naturalOrder());	//텍스트 정렬
		word.sort(new Comparator<String>(){		//길이 정렬
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		
		// 출력
		for (int i = 0; i < n; i++) {
			System.out.println(word.get(i));
		}
		// 텍스트정렬
//		while (true) { // 퀵솔트 사용
//			boolean sorted = true;
//			for (int i = 0; i < n - 1; i++) {
//				if (word.get(i).compareTo(word.get(i + 1)) > 0) {
//					if (sorted)
//						sorted = false;
//					word.add(i, word.get(i + 1));
//					word.remove(i + 2);
//				}
//			}
//			if (sorted)
//				break;
//		}
		// 길이 정렬
//		int tmp_int;
//		while (true) { // 퀵솔트 사용
//			boolean sorted = true;
//			for (int i = 0; i < n - 1; i++) {
//				if (iter[i] > iter[i + 1]) {
//					if (sorted)
//						sorted = false;
//					word.add(i, word.get(i + 1)); // 워드위치 변경
//					word.remove(i + 2);
//
//					tmp_int = iter[i];
//					iter[i] = iter[i + 1];
//					iter[i + 1] = tmp_int;
//				}
//			}
//			if (sorted)
//				break;
//		}
	}
}
