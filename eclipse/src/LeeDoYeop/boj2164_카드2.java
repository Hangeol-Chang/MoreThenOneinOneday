package LeeDoYeop;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> card = new LinkedList<Integer>();// 카드생성
		for(int i = 1; i<=N; i++) //
			card.offer(i); //일단 카드추가 i~N
		while(card.size() != 1) {
			card.poll();	// 카드 버리기
			card.offer(card.poll()); // 맨앞카드 뒤로보내기
		}
		System.out.println(card.poll()); // 마지막에 남은카드
	}
}
