class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val answer = IntArray(right.toInt() - left.toInt() + 1)
       
        for(k in left..right){
            val x = k/n
            val y = k%n
            
            answer[(k-left).toInt()] = maxOf(x.toInt(),y.toInt())+1
        }
        
        return answer
    }
}