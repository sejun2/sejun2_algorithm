import java.util.*;

class Solution {
    long answer;
    
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long minTime = 1;
        long maxTime = (long) times[times.length - 1] * n;
        
        answer = maxTime;
        
        while(minTime <= maxTime){
            long t = (minTime+maxTime)/2;
            long number = 0;
            
            for(int i =0 ;i<times.length; i++){
                number+=t/(long)times[i];
            }
            
            if(number >= n){
                answer = Math.min(answer, t);
                maxTime = t - 1;
            }else{
                minTime = t + 1;
            }
        }
     
        return answer;
    }
    
}