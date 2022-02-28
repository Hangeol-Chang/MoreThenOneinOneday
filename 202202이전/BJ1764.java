//이거 버퍼드리스트로 바꾸면 시간 얼마나 줄지?

import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class BJ1764 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        //입력받는 것들을 해쉬셋에 저장
        HashSet<String> names = new HashSet<>();
        //우리가 아는 이름들을 저장하기 위한 리스트
        ArrayList<String> outs = new ArrayList<>();

        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        //사전 입력받기
        for(int i = 0; i < n; i++){ names.add(in.nextLine()); }

        //보도 못한 사람 입력받기
        int count = 0;
        for(int i = 0; i < m; i++){
            String tmp = in.nextLine();
            //만약 보도 못한 사람이 듣도 못한 사람에 있으면
            if(names.contains(tmp)){
                //출력할 배열에 저장.
                count++;
                outs.add(tmp);
            }
        }
        //입력받은 것들 정렬.
        Collections.sort(outs);

        //출력
        System.out.println(count);
        for(String out : outs) System.out.println(out);
        in.close();
    }
}
