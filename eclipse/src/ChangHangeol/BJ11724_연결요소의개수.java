package ChangHangeol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11724_연결요소의개수 {
    static int[][] grp;
    static boolean[] visit;
    static int visitcount;
    static int n;
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        grp = new int[n+1][n+1];
        visit = new boolean[n+1];
        visitcount = n;
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            grp[t1][t2] = 1;
            grp[t2][t1] = 1;
        }
        //입력받기 끝.

        //원본배열
//        System.out.println("원본배열");
//        for(int p = 1; p <= n; p++) {
//        	for(int e = 1; e <= n; e++) {
//        		System.out.print(grp[p][e] + " ");
//        	}
//        	System.out.println();
//        }
//        System.out.println(" ");
        
        
        int count = 0;
        for(int i = 1; i <= n; i++){
            for(int j = i+1; j <= n; j++){
                if(grp[i][j] == 1 && !visit[i]) {
            		visit[i] = true;
            		visitcount--;
            		erase(i);
            		count++;
//                	System.out.println("지우기 시작");
                    
//                    System.out.println("하나 끝남");
//                    for(int p = 1; p <= n; p++) {
//                    	for(int e = 1; e <= n; e++) {
//                    		System.out.print(grp[p][e] + " ");
//                    	}
//                    	System.out.println();
//                    }
//                    System.out.println("여기까지\n");
                    break;
                }
            }
        }
        System.out.println(count + visitcount);
    }

    public static void erase(int i){
	        for(int jj = j; jj <= n; jj++){
	            if(grp[i][jj] == 1) {
	                grp[i][jj] = 0;
	                grp[jj][i] = 0;
	                
	//                System.out.println("지운 위치 : " + i + " " + jj);
	//                for(int p = 1; p <= n; p++) {
	//                	for(int e = 1; e <= n; e++) {
	//                		System.out.print(grp[p][e] + " ");
	//                	}
	//                	System.out.println();
	//                }
	//                System.out.println(" ");
	                
	                erase(jj, jj);
	                
	            }
	        }
        }
    }
}
