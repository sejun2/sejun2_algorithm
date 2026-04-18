class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var count = 0
        
        var x = Math.min(a, b)
        var y = Math.max(a, b)
        
        while(true){
            count++
            
            if(x+1 == y && x%2 == 1){
                break
            }
            
            x = Math.ceil(x/2.0).toInt()
            y = Math.ceil(y/2.0).toInt()
        }
        
        return count
    }
}