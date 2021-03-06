import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

//시간 초과

public class BJ11723 {
    public static boolean[] set = new boolean[21];

    public static void add(int n)   { set[n] = true;  }
    public static void remove(int n){ set[n] = false; }

    public static void check(int n){
        if(set[n])  System.out.println(1);
        else        System.out.println(0);
    }
    public static void toggle(int n){ set[n] = !set[n]; }
    public static void all()  { for(int i = 1; i < 21; i++) set[i] = true;  }
    public static void empty(){ for(int i = 1; i < 21; i++) set[i] = false; }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(in.readLine());
        
        for(int i = 0; i < M; i++){
            String[] order = in.readLine().split(" ");
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
