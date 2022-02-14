import java.util.Scanner;

public class SWEA1215 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t <= 1; t++){
            sb.append("#" + t + " ");
            
            //입력받기.
            int n = in.nextInt();
            in.nextLine();

            char[][] board = new char[8][];
            for(int i = 0; i < 8; i++){
                board[i] =  in.nextLine().toCharArray();
            }

            //오른쪽으로, 밑으로 내려가는 것만 검사하면 됨.
            int[][] delta = {{0, 1}, {1, 0}};

            //찾기
            int halfn = n/2;
            int num = 0;

            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){

                    for(int p = 0; p < 2; p++){
                        boolean judge = true;
                        for(int d = 0; d < halfn; d++){
                            //System.out.println(i + " " + j + " " + d + " " + p);

                            if(j - delta[p][1]*(d+ 1-n) >= 8 || i - delta[p][0]*(d + 1-n) >= 8) {
                                judge = false;
                                break;
                            }

                            char con1 = board[i + delta[p][0]*d        ][j + delta[p][1]*d       ];
                            char con2 = board[i - delta[p][0]*(d + 1-n)][j - delta[p][1]*(d+ 1-n)];
                            //System.out.println(con1 + " " + con2 + " " + i + " " + j + " " + d + " " + p);

                            if(con1 != con2){
                                judge = false;
                                break;
                            }
                        }
                        if(judge) {
                            //System.out.println("통과위치 : " + i + " " + j);
                            num++;
                        }
                    }

                }
            }
            sb.append(num + "\n");
        }
        System.out.println(sb);
        in.close();
    }
}
