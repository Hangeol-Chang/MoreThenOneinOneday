import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BJ1244 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] btns = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //들어오는 명령의 수
        int order = Integer.parseInt(br.readLine());

        for(int i = 0; i < order; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int index =  Integer.parseInt(st.nextToken());

            switch(gender) {
                case 1:
                    int j = 1;
                    while(j*index - 1 < n){
                        btns[j*index - 1] = 1-btns[j*index - 1];
                        j++;
                    }
                    break;
                case 2:
                    int d = 0;
                    while(btns[index-1 -d] == btns[index-1 +d]){
                        int tmp = btns[index-1 +d];

                        btns[index-1 +d] = 1-tmp;
                        btns[index-1 -d] = 1-tmp;
                        d++;
                        if(index-1 -d < 0 || index-1 +d >= n) break;
                    }
                    break;
            }
        }

        for(int i = 0; i < n-1; i++){
            System.out.print(btns[i]);
            if((i+1)%10 == 0) System.out.println();
            else System.out.print(" ");
        }
        System.out.print(btns[n-1]);

    }
}
