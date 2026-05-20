class Solution {
    var answer = 0
    
    fun solution(begin: String, target: String, words: Array<String>): Int {
    	bfs(begin, target, words, mutableListOf<String>()) 
        
        return answer
    }
    
    fun bfs(begin: String, target: String, words: Array<String>, visited: MutableList<String>){
        val queue = ArrayDeque<Pair<String, Int>>()
    	var count = 0
        
        queue.addFirst(begin to 0)
        
        // 처음 변환 가능한 단어 큐에 넣기
        
        while(queue.isNotEmpty()){
            // 큐에서 하나씩 빼면서 변환하고
            
            val (s, i) = queue.removeFirst()
           
            // 찾던 단어면 break
            if (s == target){
                answer = i
                return
            }
            
            for(w in words){
                // 변환 가능한 단어 찾기
           		if(!find(s, w)) continue
                if(w in visited) continue
                
                visited.add(w)
                println("visited: $w")
                
                queue.addLast(w to i+1)
            }
        }
    }
    
    fun find(current: String, s:String): Boolean{
        var diff = 0
        
        for(i in 0 until current.length) {
           if(s[i] != current[i])  diff++
        }
        
        return diff == 1
    }
}