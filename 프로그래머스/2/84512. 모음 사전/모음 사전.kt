class Solution {
    var c = -1
    var count = -1
    
    fun solution(word: String): Int {
        dfs("", word)
        
        return c
    }
    
    fun dfs(word:String, answer: String){
        count++
        
        if(word == answer) {
            c = count
            return
        }
        
        if(word.length == 5) return
        
        for(i in "AEIOU"){
            dfs(word+i, answer)
        }
    }
}