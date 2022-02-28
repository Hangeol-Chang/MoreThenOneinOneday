import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ11279_최대힙 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        PriorityQueue<Integer> pque = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(br.readLine());
            switch (tmp){
                case 0 :
                    bw.write(((pque.isEmpty()) ? 0 : pque.poll()) + "\n");
                    break;
                default :
                    pque.add(tmp);
                    break;  
            }
        }
        bw.flush();
    }
}
