package ChangHangeol;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BJ1927_최소힙 {
    static PriorityQueue<Integer> pque = new PriorityQueue<>();

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int order = Integer.parseInt(br.readLine());
        for(int t = 1; t <= order; t++){
            int input = Integer.parseInt(br.readLine());
            switch (input) {
                case 0:
                    if(pque.isEmpty()) bw.write("0\n");
                    else bw.write(pque.poll() + "\n");
                    break;

                default:
                    //숫자가 들어왔을 때, 인덱스를 찾아 삽입하는 연산.
                    //이분탐색으로 인덱스 찾아옴.
                    pque.add(input);
                    break;
            }
            //System.out.println(heap);
        }
        bw.flush();
    }
    // public static int searchidx(int st, int ed, int input){
    //     while(st < ed){
    //         int mid = (st + ed) / 2;
    //         if( heap.get(mid) > input) ed = mid;
    //         else st = mid+1;
    //     }
    //     return ed;
    // }
}
