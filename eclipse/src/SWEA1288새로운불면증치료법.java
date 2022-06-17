

import java.util.Scanner;

public class SWEA1288새로운불면증치료법 {

  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      StringBuilder sb = new StringBuilder();
      int T = in.nextInt();
      
      for(int t = 1; t <= T; t++){
          boolean[] isin = new boolean[10];
          int n = in.nextInt();
          int n2 = 0;
          
          int checker = 10;
          int k = 1;
          while(checker > 0) {
              n2  = k*n;
              int tmp = n2;
              while(tmp > 0){
                  if(!isin[tmp%10]) {
                      isin[tmp%10] = true;
                      checker--;
                  }
                  tmp /= 10;
              }
              k++;
          }
          sb.append("#" + t + " " + n2 + "\n");
      }
      System.out.println(sb);

  }
}
