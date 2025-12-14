class Solution {
    var answer: IntArray = intArrayOf()
    var answerList: ArrayList<Int> = arrayListOf()
    
    val dx: IntArray = intArrayOf(0, 1, 0, -1)
    val dy: IntArray = intArrayOf(-1, 0, 1, 0)
    
    fun solution(maps: Array<String>): IntArray {
        val tmpMap: Array<Array<Int>> = Array<Array<Int>>(maps.size, {Array(maps[0].length, {0})})
        
        for(i in 0 until maps.size){
            for(j in 0 until maps[0].length){
                var value = maps[i][j]
                
                if(value.toString().equals("X")){
                    tmpMap[i][j] = -1
                }else{
                    tmpMap[i][j] = value.toString().toInt()
                }
            }
        }
        
       // println(tmpMap.contentDeepToString())
       
        val visited = Array<Array<Boolean>>(tmpMap.size, {
            Array<Boolean>(tmpMap[0].size, {false})
        })
            
        for(i in 0 until tmpMap.size){
            for(j in 0 until tmpMap[0].size){
               val sum = dfs(visited, tmpMap, i, j)
               
               if(sum >0) {
                   answerList.add(sum)
               }
            }
        }
        
        if(answerList.size == 0) return intArrayOf(-1)
        
        answerList.sort()
        
        return answerList.toIntArray()
    }
    
    fun dfs(visited: Array<Array<Boolean>>, maps: Array<Array<Int>>, x:Int, y:Int): Int{
        if(x <0 || y <0 || x >= maps.size || y >= maps[0].size) return 0
        
        if(maps[x][y] == -1) return 0
        
        if(visited[x][y]) return 0 
        
        visited[x][y] = true
        
        println("$x, $y 방문")
        
        var sum = maps[x][y]
        
        for(i in 0..3){
            sum += dfs(visited, maps, x+dx[i], y+dy[i])
        }
        
        return sum
    }
}