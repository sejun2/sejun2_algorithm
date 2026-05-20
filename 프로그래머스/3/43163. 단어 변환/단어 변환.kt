class Solution {
    var count = 0
    var find = false
    
    fun solution(begin: String, target: String, words: Array<String>): Int {
    	bfs(begin, target, words, mutableListOf<String>()) 
        
        return if(find) count else 0
    }
    
    fun bfs(begin: String, target: String, words: Array<String>, visited: MutableList<String>){
        val queue = ArrayDeque<String>()
        
        queue.addFirst(begin)
        
        // 처음 변환 가능한 단어 큐에 넣기
        
        while(queue.isNotEmpty()){
            // 큐에서 하나씩 빼면서 변환하고
            
            val s = queue.removeFirst()
           
            // 찾던 단어면 break
            if (s == target){
                find = true
                return
            }
            
            for(w in words){
                // 변환 가능한 단어 찾기
           		if(!find(s, w)) continue
                if(w in visited) continue
                
                visited.add(w)
                println("visited: $w")
                
                queue.addFirst(w)
            }
            
            // 카운트 증가
            count++
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