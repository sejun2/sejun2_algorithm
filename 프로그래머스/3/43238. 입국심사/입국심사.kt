class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var left: Long = 1L
        var right:Long = times.maxOf{it}.toLong() * n
        
        while(left != right-1){
           var mid = (left + right) / 2 
            
           if(isPossible(mid, n, times)){
               right = mid
           }else{
               left = mid
           }
        }
        
        return right
    }
    
    fun isPossible(mid:Long, n: Int, times: IntArray): Boolean{
        var p: Long = 0
        
      times.forEach {
          it -> p += mid/it
      } 
      
      return p >= n 
    }
}