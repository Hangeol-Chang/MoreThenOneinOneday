#include <string>
#include <vector>
#include <cmath>

using namespace std;

long long solution(int r1, int r2) {
    // x^2 + y^2 = r^2
    long long answer = 0;
    
    long long rr1 = (long long)r1 * r1;
    long long rr2 = (long long)r2 * r2;
    
    for(long long x = 1; x <= r2; x++) {
        // long long yMin = (long long)(sin(acos(x * 1.0 / r1)) * r1);
        // long long yMax = (long long)(sin(acos(x * 1.0 / r2)) * r2);
        
        long long xx = x * x;
        
        long long yMin = (long long)(sqrt(rr1 - xx));
        long long yMax = (long long)(sqrt(rr2 - xx));
        
        // printf("%d %d %d\n", x, yMin, yMax); 
        
        long long minChecker = yMin * yMin + x * x;
        long long maxChecker = yMax * yMax + x * x;

        if(minChecker >= rr1 && maxChecker <= rr2) ++answer;
        
        answer += yMax - yMin;
    }
    
    answer *= 4;
    return answer;
}