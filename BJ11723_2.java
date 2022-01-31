//비트마스크 활용.
//1 ~ 10까지 묶어서 한개.
//11 ~ 20까지 묶어서 한 개 총 두 개 사용.

import java.util.Scanner;
public class BJ11723_2 {
    public static int set1 = 0;
    public static int set2 = 0;

    public static void add(int n)   { set[n] = true;  }
    public static void remove(int n){ set[n] = false; }

    public static void check(int n){
        if(set[n])  System.out.println(1);
        else        System.out.println(0);
    }
    public static void toggle(int n){ set[n] = !set[n]; }
    public static void all()  { for(int i = 1; i < 21; i++) set[i] = true;  }
    public static void empty(){ for(int i = 1; i < 21; i++) set[i] = false; }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        in.nextLine();
        
        for(int i = 0; i < M; i++){
            String[] order = in.nextLine().split(" ");
            switch(order[0]){
                case "add" :
                    add(Integer.parseInt(order[1]));
                    break;
                case "remove" :
                    remove(Integer.parseInt(order[1]));
                    break;
                case "check" :
                    check(Integer.parseInt(order[1]));
                    break;
                case "toggle" :
                    toggle(Integer.parseInt(order[1]));
                    break;
                case "all" :
                    all();
                    break;
                case "empty" :
                    empty();
                    break;
            }
        }
        in.close();
    }
}
