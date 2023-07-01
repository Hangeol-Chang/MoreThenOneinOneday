

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BJ2263_트리순회 {
    // 중위, 후위순회를 주고, 전위순회를 구하라.
    static int[] mid;
    static int[] end;
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());  
        
        mid = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        end = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 후위표기식을 맨 뒤에서부터 읽어오면서 진행.
        printSystem(0, N-1, 0, N-1);
        System.out.println(sb);
    }
    
    // 분할정복으로 나눠가면서
    // 왼쪽, 오른쪽에 자식이 한 개 이하로 남았으면 자식을 넣고 리턴하고,
    // 두 개 이상이면 자식들로 함수를 호출.
    // 인자로 왼쪽 한계값과, 오른쪽 한계값을 입력받음.
    public static void printSystem(int miter, int eiter, int lend, int rend){
        // miter값 옮기기.(최상위 노드 위치 찾기)
        while(miter < rend && mid[miter] != end[eiter]) miter++;
        //V
        sb.append(end[eiter] + " ");
        //왼쪽, 오른쪽 자식 수에 따른 처리
        // L
        switch(miter - lend){
        case 0 :
            break;
        case 1 :
            sb.append(mid[lend] + " ");
            break;
        default :
            printSystem(lend, eiter-(rend-miter+1), lend, miter-1);
        }
        // R
        switch(rend - miter){
        case 0 :
            break;
        case 1 :
            sb.append(mid[rend] + " ");
            break;
        default :
            printSystem(miter+1, eiter-1, miter+1, rend);
        }
    }
}
/*

1 2 4 3 5 6 7

7
4 2 1 5 3 6 7
4 2 5 7 6 3 1

15
8 4 9 2 10 5 11 1 12 6 13 3 14 7 15
8 9 4 10 11 5 2 12 13 6 14 15 7 3 1
*/