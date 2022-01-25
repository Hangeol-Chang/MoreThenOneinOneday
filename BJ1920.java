import java.util.Scanner;

public class BJ1920{
    static int size = 1;            //현재 트리의 사이즈.

    public static boolean search(long[] data, int[][] tree){
        return true;
    }
    public static void addtree(long[] data, int[][] tree, int index, int input, int size){
        long comparedata = data[index]; //입력값과 비교할 데이터.
        if(data[index] == 0 ) data[index] = input;
        else{
            if(input > data[index]) {
                if( tree[index][1] == 0 ){                  //연결된 노드가 없을 때.
                    tree[index][1] = ++size;
                }else{
                    addtree(long[] data, tree, index, input, )
                }
            }

        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        long[] data = new long[n+1];    //n개의 데이터 저장
        int[][] tree = new int[n+1][2]; //데이터의 트리 엣지들
        for(int i = 0; i < n; i++){
            addtree(data, tree, 1, in.nextInt(), size);
            data[i] = in.nextInt();

        }
        
        int m = in.nextInt();
        //있는지 없는지 판단할 공간.
        boolean[] isin = new boolean[m+1];
    }
}