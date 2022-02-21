import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Stream;
public class SWEA5099_피자굽기 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();

        int T = in.nextInt();
        for(int t = 1; t <= T; t++){
            int n = in.nextInt();   //화덕의 수
            int m = in.nextInt();   //
            in.nextLine();
            int[] pizza = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            //초기에 n개 회덕에 넣기.
            for(int i = 0; i < n; i++){ que.add(i); }
            
            int lastburn = 0;
            while(!que.isEmpty()){
                int getp = que.poll();
                pizza[getp] /= 2;
                
                if(pizza[getp] == 0){
                    lastburn = getp + 1;
                    if(n < m) que.add(n++);
                }else           que.add(getp);
            }
            
            sb.append("#" + t + " " + lastburn + "\n");
        }
        System.out.println(sb);
        in.close();
    }
}

// //최초에 피자 화덕에 넣기.
// int lastburn = 0;
// int i = 0;
// burn : while(true) {
//     int burn = 0;
//     //화덕의 크기만큼 태움.
//     while(burn < n) {
//         if(pizza[i] > 0) {
//             pizza[i] = pizza[i]/2;
//             burn++;
//             //System.out.print("이거태움 : " + i + " " + pizza[i] + ", ");
//             if(pizza[i] == 0) {
//                 lastburn = i+1;
//             }
//         }
//         i = ++i%m;
//         //빠져나갈 수 있는지 판단.
//         boolean zero = true;
//         for(int piz : pizza){
//             if(piz != 0) zero = false;
//         }
//         if(zero) break burn;
//     }
//     //System.out.println();
// }