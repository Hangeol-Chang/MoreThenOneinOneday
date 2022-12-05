

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1251_하나로_서경누나 {

   static Scanner sc = new Scanner(System.in);
   static int num;
   static long[][] island;
   static long[][] edges;
   
   public static void main(String[] args) {
   
      int T = sc.nextInt(); //테스트케이스
      StringBuilder sb = new StringBuilder();
      
      for(int t = 0; t < T; t++) {
         num = sc.nextInt(); //섬의 개수
         island = new long[num][2]; //각 섬의 x, y좌표
         edges = new long[num][num]; //에지들의 값
         
         put(0);
         put(1); // 섬의 x, y 값을 넣기
         
         edgeCalc(); //각 에지들의 값
                  
         double E = sc.nextDouble(); //환경부담세율
      
         boolean[] visited = new boolean[num]; //방문처리
         long[] dist = new long[num]; //거리
         long[] root = new long[num]; //조상
         
         Arrays.fill(dist, Long.MAX_VALUE); //최소를 구할 것이므로 각 거리는 최대값으로 초기화
         
         dist[0] = 0;
         root[0] = -1;
         //0번 인덱스부터 시작
         
         long min = 0; 
         double sum = 0; 
         int idx = 0; //최소값, 최소값의 인덱스, 총합을 초기화
         
         for(int i = 0; i < num-1 ; i++) {
            min = Long.MAX_VALUE;
            idx = -1;
            // 초기화
            for(int j = 0; j < num; j++) {
               if(!visited[j] && dist[j] < min) {
                  min = dist[j];
                  idx = j;
               }
            }
            
            visited[idx] = true; //dist 값이 제일 작은 것 중 아직 안 같 것 체크
            
            for(int j = 0; j < num; j++) {
               if(!visited[j] && edges[idx][j] != 0 && dist[j] > edges[idx][j]) {
                  root[j] = idx;
                  dist[j] = edges[idx][j];
               }
            }
         }
         
         for(int i = 0; i < num; i++) {
            sum += dist[i];
         }
         
         long sum2 = Math.round(E*sum);
         
         sb.append("#").append(t+1).append(" ").append(sum2).append("\n");
         
      }
      
      System.out.println(sb);
      
   }
   
   private static void edgeCalc() {
      for(int i = 0; i < num; i++) {
         for(int j = 0; j < num; j++) {
            edges[i][j] = (long) (Math.pow(island[i][0]-island[j][0], 2) + Math.pow(island[i][1]-island[j][1], 2));
         } //각 섬의 거리의 제곱
      }
   }

   private static void put(int idx) {
   
      for(int i = 0; i < num; i++) {
         island[i][idx] = sc.nextLong();
      }
   }
   
}

/*

1
9
567 5 45674 24 797 29 0 0 0
345352 5464 145346 54764 5875 0 3453 4545 123
0.0005

27365366
*/