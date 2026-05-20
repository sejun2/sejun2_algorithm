class Solution {
    var answer: Int = 0
    
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        
        dfs(dungeons, BooleanArray(dungeons.size), k, 0)
       	
        return answer
    }
    
    fun dfs(dungeons: Array<IntArray>, visited: BooleanArray, k: Int, count: Int){
        answer = maxOf(count, answer)
        
        for(i in dungeons.indices){
           if(visited[i]) continue
           if(k < dungeons[i][0]) continue
            
       	   visited[i] = true
           dfs(dungeons, visited, k - dungeons[i][1], count+1) 
           visited[i] = false
        }
        
        
    }
}