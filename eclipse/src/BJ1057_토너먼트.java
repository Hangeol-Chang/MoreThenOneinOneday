import java.io.*;
import java.util.*;

/*
n명이 참가하는 스타 토너먼트.
1번부터 N번까지 배정.

불가능하면 -1 출력하라는데, -1 출력되는 경우가 없는데?

 */
public class BJ1057_토너먼트 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 0;
        while(a != b) {
            a = (a+1)/2;
            b = (b+1)/2;
            count++;
        }
        System.out.print(count);
    }
}
