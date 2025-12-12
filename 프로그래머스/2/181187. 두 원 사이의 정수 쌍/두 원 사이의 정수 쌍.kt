import kotlin.math.*


class Solution {
    
    var answer: Long = 0;
    var triv: Long = 0;
    
    // x^2 + y^2 = r^2
    fun solution(r1: Int, r2: Int): Long {
        val bigR = Math.max(r1, r2)
        val smallR = Math.min(r1, r2)
       
        val startX = -bigR;
        val startY = bigR;
        
        val endX = bigR;
        val endY = -bigR;
        
        for(i in 0..bigR){
            val maxY: Long = floor(sqrt(bigR.toDouble() * bigR - i.toLong()  * i.toLong())).toLong()
            var minY: Long = ceil(sqrt(smallR.toDouble() * smallR - i.toLong()  * i.toLong())).toLong()
           
            if(i == 0){
                triv = triv + maxY - minY + 1
                continue;
            }
            
            if(minY.toInt() == 0){
                answer = answer + maxY - minY
                triv++
                continue;
            }
            
            answer += maxY - minY + 1
        }
        
        return answer * 4 + triv * 2
    }
    
}