import java.util.Scanner;

public class BJ2477_참외밭{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int density = in.nextInt();
        int[] farms = new int[6];

        for(int i = 0; i < 6; i++){
            in.nextInt(); // 01 23
            farms[i] = in.nextInt();
        }
        int xmax = 0;
        int ymax = 0;

        //최대 박스 찾기
        for(int i = 0; i < 6; i++){
            //세로길이
            if(i % 2 == 0) {
                if (ymax < farms[i])  ymax = farms[i];
            } else if(xmax < farms[i])  xmax = farms[i]; 
        }
        
        //System.out.println(ymax + " " + xmax);
        int xmin = 0;
        int ymin = 0;
        for(int i = 0; i < 6; i++){
            if(i % 2 == 0) {
                if(farms[(i+5)%6] + farms[(i+1)%6] == xmax) { ymin = farms[i]; }
            } else if( farms[(i+5)%6] + farms[(i+1)%6] == ymax) { xmin = farms[i]; }
        }

        //System.out.println(ymin + " " + xmin);
        int bigbox   = ymax * xmax;
        int smallbox = ymin * xmin;
        
        int totalbox = bigbox-smallbox;
        System.out.println(totalbox * density);
        in.close();
    }    
}

/*
7
3 50
2 100
4 20
2 60
4 30
1 160


7
2 160
3 30
1 60
3 20
1 100
4 50
*/