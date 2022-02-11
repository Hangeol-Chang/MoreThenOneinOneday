import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class SWEA_1210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            String junk = br.readLine();  //정크자료 버리기
            sb.append("#" + t + " ");
            int[][] ladder = new int[100][];

            //사다리 입력받기
            for(int i = 0; i < 100; i++){
                ladder[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            //목표지점 인덱스 찾기
            int idxy = 99;                      //시작 y지점
            int idxx = 0;                       //시작 x지점은 밑에서 찾음.
            for(int i = 0; i < 100; i++) {
                if(ladder[99][i] == 2) { 
                    idxx = i; 
                    break; 
                }
            }

            // 디버깅용 코드
            // for(int i = 0; i< 100;i++){
            //     for(int j = 0; j<100; j++) System.out.print(ladder[i][j]);
            //     System.out.println(" " + i);
            // }
            // System.out.println("출발 x : " + idxx);

            //아래로는 내려갈 일 없고, 위는 그냥 이동하면 되는거니까. 좌우 두개만 사용
            int[] drc = {-1, 1};

            //목표지점부터 찾아 올라갈거임
            //언제까지? y값이 0이 될 때까지
            while(idxy > 0){
                //좌우에 길 있는지 확인
                for (int i = 0; i < 2; i++){
                    //좌우를 검사
                    int nx = idxx + drc[i];
                    
                    //배열의 범위 안에 있고, 좌우에 길이 있는지 확인
                    if( (nx >= 0 && nx < 100) && ladder[idxy][nx] == 1 ){

                        //길이 끝날 때 까지 그 방향으로 이동.
                        while(ladder[idxy][nx] == 1) {
                            nx += drc[i];
                            if(nx < 0 || nx >= 100) break;   //과정에서 범위 초과하면 break;
                        }
                        idxx = nx - drc[i];
                        //여기서 브레이크를 걸지 않으면,
                        //사다리 왼쪽으로 움직였다가, 오른쪽으로 다시 돌아옴.
                        break;
                    }
                }
                
                //길이 없으면 위로 올라감
                idxy--;
            }
            sb.append(idxx + "\n");
        }
        System.out.println(sb);
    }    
}
