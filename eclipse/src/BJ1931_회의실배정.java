

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1931_회의실배정 {
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
                if(conf1.end == conf2.end) return conf1.start - conf2.start;
                return conf1.end - conf2.end;
            }
        });

        int i = 0;
        int count = 0;
        int endtime = 0;
        while(i < n) {
            endtime = conference.get(i++).end;
            count++;
            while(i < n && endtime > conference.get(i).start) i++;
        }
        System.out.println(count);
    }
}