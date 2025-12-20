class Solution {
    var answer: Long = 0
    
    fun solution(n: Int): Long {
        val dp = Array<Long>(n+1){
            0
        }
        
        if(n == 0) return 0
        if(n == 1) return 1
        if(n == 2) return 2
        
        dp[0] = 0
        dp[1] = 1
        dp[2] = 2
        
       
        for(i in 3 .. n){
           dp[i] = (dp[i-1] + dp[i-2]) % 1234567
        }
        
        return dp[n] 
    }
    
    fun dfs(current:Long, n: Int){
        if(current > n) return
        
        if(current == n.toLong()){
            answer++
        }
        
        dfs(current+1, n)
        dfs(current+2, n)
    }
}