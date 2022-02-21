import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11723_2 {
    static int set = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            
            switch(order) {
            case "add" :
                add(Integer.parseInt(st.nextToken()));
                break;
            case "remove" :
                remove(Integer.parseInt(st.nextToken()));
                break;
            case "check" :
                sb.append((check(Integer.parseInt(st.nextToken()))? 1 : 0) + "\n");
                break;
            case "toggle" :
                toggle(Integer.parseInt(st.nextToken()));
                break;
            case "all" :
                set = 2097151;
                break;
            case "empty" :
                set = 0;
                break;
            }
        }
        System.out.println(sb);
    }
    
    public static boolean check(int a){
        return (set & 1<<a) == 1<<a;
    }
    public static void add(int a){
        if(!check(a)) set += 1<<a;
    }
    public static void remove(int a){
        if(check(a)) set -= 1<<a;
    }
    public static void toggle(int a) {
        if(check(a)) set -= 1<<a;
        else set += 1<<a;
    }
}
