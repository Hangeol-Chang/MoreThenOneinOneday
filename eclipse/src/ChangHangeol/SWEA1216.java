package ChangHangeol;
import java.util.Scanner;

public class SWEA1216 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t <= 10; t++){
            sb.append("#" + t + " ");
            String junk = in.nextLine();	//정크데이터 버림

            //사이즈 바꿔가면서 테스트할라고 그냥 정의함.
            int size = 100;
            char[][] board = new char[size][];
            for(int i = 0; i < size; i++){
                board[i] =  in.nextLine().toCharArray();
            }

            //오른쪽으로, 밑으로 내려가는 것만 검사하면 됨.
            //이를 델타로, delta[0]을 x축 검사, delta[1][]을 y축 검사에 사용.
            int[][] delta = {{0, 1}, {1, 0}};

            //찾기
            int maxlen = 0;
            //y축 인덱스 i, x축 인덱스 j
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){

                    //델타의 0, 1을 바꿔줄 변수 p
                    for(int p = 0; p < 2; p++){

                        //길이가 1인 것부터 size인 것까지 돌리기
                        for(int n = 1; n <= size; n++) {
	                        //배열의 앞에 반이 뒤에 반이랑 맞는지 검사.
                            boolean judge = true;
                            
	                        for(int d = 0; d < n/2; d++){

	                            //찾고 있는 게 인덱스 범위를 초과해버리면 브레이크
	                            if(j - delta[p][1]*(d-n+1) >= size || i - delta[p][0]*(d-n+1) >= size) {
	                                judge = false;
	                                break;
	                            }
	
	                            /*
	                                                 맨 처음꺼랑 맨 뒤에꺼 비교, 앞에서 2번째랑 뒤에서 2번째랑 비교 ~~~~방식으로 비교 진행.
	
	                                                 기본 board[i][j]의 형태에서 출발하여
	                            
	                            delta[p][0]*d 는 앞에서 출발한 것(con1)의 위치를 가르킴.
	                            d가 0에서 출발하므로, 전체 [i + delta[p][0]*d] 는 p에 따라 고정될 수도 있고, 0 ~ halfn까지 검색을 진행하게 됨.
	
	                            - delta[p][0]*(d + 1-n)는 뒤에서 출발한 것의 위치를 가르킴.
	                                                 저게 앞에 -가 붙어서 식이 괴랄한데, 풀어보면 delta*(n-1 - d)가 됨.
	                            n-1에서 출발하여, d가 커짐에 따라 한칸씩 앞으로 와서, halfn + 1 까지 도달함.
	                            */
	                            //System.out.println((j + delta[p][1]*d) + " " + (j - delta[p][1]*(d-n+1)));
	                            
	                            char con1 = board[i + delta[p][0]*d        ][j + delta[p][1]*d       ];
	                            char con2 = board[i - delta[p][0]*(d-n+1)][j - delta[p][1]*(d-n+1)];
	
	                            //위에서 찾은 두 문자가 다르면 브레이크
	                            if(con1 != con2){ judge = false; break; }
	                        }

	                        if(judge && maxlen < n) { 
	                        	//System.out.println("통과길이 : " + n);
		                        //System.out.println("현재위치 : " + i + " " + j + ", 측정 길이 : " + n);
	                        	maxlen = n; }
                        }
                    }
                }
            }
            sb.append(maxlen + "\n");
        }
        System.out.println(sb);
        in.close();
    }
}
