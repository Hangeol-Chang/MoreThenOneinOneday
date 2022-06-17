
import java.util.Arrays;
import java.util.Scanner;

public class JO1205_조커 {
    static int n;
    static int[] nums;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        n = in.nextInt();
        nums = new int[n];
        for(int i = 0; i < n; i++){ nums[i] = in.nextInt(); }
        Arrays.sort(nums);
        // n = nums.length;
        
        //조커의 수를 셈.
        int idx = 0;
        while(idx < n && nums[idx] == 0){ idx++; }
        //입력받은게 전부 0인 경우.
        if(idx == n) { System.out.println(n); in.close(); return; }
        //idx가 조커의 수 임과 동시에, 스트레이트 판단의 시작 위치가 됨.

        
        int straight = 0;
        for(int i = idx; i < n; i++){
            straight = Math.max(straight, counting(i, nums[i], idx, 1));
        }
        System.out.println(straight);
        in.close();
    }

    public static int counting(int i, int num, int zokercount, int count){

        //인덱스 범위를 벗어나면 브레이크
        if(i >= n-1) return zokercount + count;
        
        //두 수가 이어지지 않는 상황에서.
        else if( nums[i+1] - num != 1){

            //조커를 쓸 수 없으면 count 리턴,
            if(zokercount == 0) return count;
            else{
                //조커를 쓸 수 있으면 사용하고 계속 진행.
                //만약 내 뒤에꺼랑 나랑 같은 숫자면, 조커를 쓰지 않고 인덱스만 1 올림
                if(nums[i+1] == num) return counting(i+1, num, zokercount, count);
                else return counting(i, num+1, zokercount-1, count+1);
            }
        }

        //수가 이어지고 있으면 다음 수를 진행해서 리턴.
        else{ return counting(i+1, nums[i+1], zokercount, count+1); }
    }
}
/*
1000
348 431 453 0 377 0 355 794 0 0 651 0 0 6 851 400 0 331 0 0 582 781 105 0 0 0 0 0 0 0 0 303 0 0 0 0 0 456 474 0 0 0 0 609 0 0 176 643 0 0 619 746 915 0 0 297 0 764 0 0 0 0 174 575 224 302 930 0 0 750 245 0 816 0 466 65 798 0 319 0 0 797 59 50 0 383 766 898 132 132 0 0 271 334 521 0 775 0 0 0 326 667 0 0 0 0 306 575 0 0 0 830 641 991 815 254 295 0 0 0 818 0 0 0 307 0 0 359 991 0 0 0 149 54 880 364 0 242 0 748 0 0 0 0 13 894 764 0 0 748 981 114 780 948 0 578 678 276 130 431 0 643 0 0 297 0 125 985 0 279 762 0 127 0 0 113 984 383 139 0 636 566 0 340 0 0 0 0 0 0 0 622 0 219 0 0 0 0 329 714 309 766 0 589 0 0 0 306 0 0 851 0 440 475 169 3 285 380 0 0 106 963 317 624 470 960 0 853 0 0 0 0 879 731 386 708 0 366 0 475 112 0 323 0 20 0 0 0 0 0 0 320 0 0 851 903 590 979 356 316 428 0 71 811 0 0 0 476 0 0 0 254 0 0 0 297 0 0 727 0 420 651 753 0 940 0 0 622 612 0 0 0 50 532 0 95 0 798 0 0 0 0 708 0 0 988 975 0 0 0 0 987 0 859 177 0 781 0 0 504 0 0 586 0 221 0 184 0 0 0 0 192 0 0 254 0 284 0 0

6
99 100 100 0 100 102
*/