import java.io.*;
import java.util.*;

public class BJ1068_트리 {
    // 노드의 수 만큼 vector 선언.
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 트리 선언.
        ArrayList<Integer>[] arr = new ArrayList[N];
        int[] p = new int[N];
        for(int i = 0; i < N; i++) arr[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int stt = 0;
        for(int i = 0; i < N; i++) {
            int pr = Integer.parseInt(st.nextToken());
            p[i] = pr;

            if(pr == -1) {
                // 시작 위치 잡기.
                stt = i;
                continue;
            } 

            arr[pr].add(i);
        }
        // 트리 완성

        // 지울 것.
        int del = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<Integer>();

        // 자식이 없으면 ans+1, but del노드로는 못내려가게 함.
        int ans = 0;
        if(del != stt) que.add(stt);
        while(!que.isEmpty()) {
            int now = que.poll();

            boolean empty = true;
            
            for(int num : arr[now]) {
                if(num == del) continue;

                que.add(num);
                empty = false;
            }
            if(empty) ans++;
        }
        System.out.print(ans);
    }
}
