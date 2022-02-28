package ChangHangeol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//해쉬맵으로 받아서 정렬해서 풀어봐도 좋을듯.
public class BJ2304 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] box = new int[1001];
        int maxh = 0;
        int maxidxf = 0;
        int maxidxe = 0;
        int maxidx = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            box[idx] = Integer.parseInt(st.nextToken());
            
            maxidx = Math.max(idx, maxidx);
            if(maxh < box[idx]){
                maxh = box[idx];
                maxidxf = idx;
                maxidxe = 0;
            }else if(maxh == box[idx]){
                maxidxe = idx;
            }
        }
        if(maxidxe == 0) maxidxe = maxidxf;
        //입력받기 끝
        int sum = 0;
        int h = 0;
        for(int i = 0; i < maxidxf; i++){
            h = Math.max(h, box[i]);
            sum += h;
        }
        h = 0;
        for(int i = maxidx; i > maxidxe; i--){
            h = Math.max(h, box[i]);
            sum += h;
        }
        sum += maxh*(maxidxe - maxidxf + 1);
        System.out.println(sum);
    }
}

/*
7
2 4
11 4
15 8
4 6
5 3
8 10
13 6
*/