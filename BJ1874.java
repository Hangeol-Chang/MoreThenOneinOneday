import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class BJ1874 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] nums = new int[n];                        //입력값 저장
        Stack<Integer> stack = new Stack<>();           //스택 쌓고 뺄 변수
        List<String> log = new ArrayList<String>();     //push, pop 기록할 배열

        int pointer = 0;                                //현재 변수 위치
        for(int i = 0; i < n; i++) nums[i] = in.nextInt();

        for(int k = 0; k < n; k++){                     //입력받아 스택 입출력
            //현재 변수위치부터 입력받은 위치까지 스택 쌓기
            for(int i = pointer + 1; i <= nums[k]; i++){    
                stack.push(i);
                log.add("+");
                pointer++;
            }        

            if(nums[k] == stack.peek()){
                //현재변수가 입력값이랑 같으면 pop하고, 이를 수열에 저장.
                stack.pop();
                log.add("-");
            }else {
                //다르면, 수열만드는게 불가능하므로, 프로그램 종료
                System.out.println("NO");
                return;
            } 

        }
        in.close();
        
        //스택 쌓은동안 한 연산 출력
        for(int i = 0; i < log.size(); i++){
            System.out.println(log.get(i));
        }
    }
}
