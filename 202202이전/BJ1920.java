//시간 초과
import java.util.Scanner;

public class BJ1920{
    static int size = 0;            //현재 트리의 사이즈.

    public static boolean search(long[] data, int[][] tree, int index, int input){
        boolean judge = false;

        if (data[index] == input) {
            //System.out.println("    노드발견 : 현재 위치 : " + index + ", 값 : " + data[index] + ", 찾던 값 : " + input);
            judge = true;
        } else{
            if(input > data[index]) {
                if( tree[index][1] == 0 ){                  //연결된 노드가 없을 때.
                    //System.out.println("상위노드없음 : 현재 위치 : " + index + ", 값 : " + data[index] + ", 찾던 값 : " + input);
                    judge = false;
                }else{ judge = search(data, tree, tree[index][1], input); }
            }else {
                if( tree[index][0] == 0 ){
                    //System.out.println("하위노드없음 : 현재 위치 : " + index + ", 값 : " + data[index] + ", 찾던 값 : " + input);
                    judge = false;
                }else{ judge = search(data, tree, tree[index][0], input); }
            }
        }
        return judge;
    }
    public static void addtree(long[] data, int[][] tree, int index, int input){
        if(data[index] == 0 ) {
            data[index] = input;
            size++;
            //System.out.println("초기데이터 : " + input + ", 데이터위치 : "+ size);
        } else{
            if(input > data[index]) {
                if( tree[index][1] == 0 ){                  //연결된 노드가 없을 때.
                    tree[index][1] = ++size;
                    data[size] = input;
                    //System.out.println("상위트리결합 값 : " + input + ", 데이터위치 : "+ size);
                }else{ addtree(data, tree, tree[index][1], input); }
            }else {
                if( tree[index][0] == 0 ){
                    tree[index][0] = ++size;
                    data[size] = input;
                    //System.out.println("하위트리결합 값 : " + input + ", 데이터위치 : "+ size);
                }else{ addtree(data, tree, tree[index][0], input); }
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] data = new long[n+1];    //n개의 데이터 저장
        int[][] tree = new int[n+1][2]; //데이터의 트리 엣지들

        for(int i = 0; i < n; i++){     //트리 만들기
            addtree(data, tree, 1, in.nextInt());
            //System.out.println("위치 : " + i+1 + ", 값 : " + data[i+1]);
        }

        /*
        for(int i = 1; i < n+1; i++){
            System.out.println("위치 : " + i + ", 값 : " + data[i] + ", 엣지 : " + tree[i][0] + " " + tree[i][1]);
        }
        */

        int m = in.nextInt();
        //있는지 없는지 판단할 공간.
        boolean[] isin = new boolean[m+1];

        for(int i = 1; i < m+1; i++){   //있는지 없는지 판단.
            isin[i] = search(data, tree, 1, in.nextInt());
        }
        in.close();
        
        for(int i =1; i < m+1; i++){
            System.out.println(isin[i] ? 1 : 0);
        }
    }
}