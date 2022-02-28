import java.util.Scanner;
public class BJ2609 {
    public static int gcf(int n1, int n2) { //최대공약수
        for(int i = n1; i > 0 ; i--)
            if(n1 % i == 0 && n2 % i == 0) return i;
        return 1;
    }
    public static int lcm(int n1, int n2) { //최소공배수
        int tmp = n1 * n2;
        for(int i = n2; i < tmp; i++)
            if(i % n1 == 0 && i % n2 == 0) return i;
        return tmp;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int c1 = in.nextInt();
        int c2 = in.nextInt();
        in.close();

        //작은 수를 n1에 넣음.
        int n1 = 0;
        int n2 = 0;
        if(c1 < c2) { n1 = c1; n2 = c2; }
        else        { n1 = c2; n2 = c1; }

        System.out.println(gcf(n1, n2));
        System.out.println(lcm(n1, n2));
    }
}
