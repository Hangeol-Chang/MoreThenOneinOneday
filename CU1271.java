import java.util.Scanner;
public class CU1271 {
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int max = 0;
    for(int i = 0; i < n; i++){
      int tmp = in.nextInt();
      if(tmp > max) max = tmp;
    }
    in.close();
    System.out.println(max);
  }
}
