class Solution {
    fun solution(numbers: IntArray): String {
        val numStrings = Array<String>(numbers.size){
            numbers[it].toString()
        }
        
        val sorted = numStrings.sortedWith{
            a,b -> -((a+b).toInt() - (b+a).toInt())
        }
           
        if(sorted.joinToString("").startsWith("0")) return "0"
        
        return sorted.joinToString("")
    }
}