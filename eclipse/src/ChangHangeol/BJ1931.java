import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1931 {
    static class conf{
        public int start;
        public int end;

        public conf(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<conf> conference = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            conference.add( new conf( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) ) );
        }
        Collections.sort(conference, new Comparator<conf>() {
            @Override
            public int compare(conf conf1, conf conf2) {
                if(conf1.start < conf1.start) return -1;
                else if(conf1.start > conf1.start) return 1;
                else return 0;
            }
        });

        int i = 0;
        int count = 0;
        while(i < conference.size()){
            //회의 끝나는 최소 시간 찾기.
            int firstout = conference.get(i).end;
            for( int j = i; j < conference.size(); j++ ) { firstout = Math.min(firstout, conference.get(j).end); }
            //그 회의를 채택하고,
            count++;
            //시작시간이 얘 다음꺼인 인덱스로 i를 이동.
            while(i < conference.size() && conference.get(i).start <= firstout ) i++;
        }
        System.out.println(count);
    }
}
