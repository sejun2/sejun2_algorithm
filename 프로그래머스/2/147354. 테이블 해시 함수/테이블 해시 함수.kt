class Solution {
	
fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
    val sorted = data.sortedWith(
        compareBy<IntArray> { it[col-1] }.thenByDescending { it[0] }
    )

    var answer = 0

    for(i in row_begin-1 until row_end){
       answer = answer xor sorted[i].sumOf { it %  (i+1)}
    }

    return answer
}
}