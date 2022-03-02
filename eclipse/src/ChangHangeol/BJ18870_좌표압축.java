package ChangHangeol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class BJ18870_좌표압축 {
	static int[] nums;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt(br.readLine());
    	nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    	//제일 작은걸 0으로 잡고,
        //쓸 수를 1씩 올려가면서, 찾게 되는 수에 대입.

        //우선순위 큐에 입력된 값들을 다 넣고,(중복은 제거)
        //이를 인덱스로 찾아올 수 있게 변환하여~~
    }
}
