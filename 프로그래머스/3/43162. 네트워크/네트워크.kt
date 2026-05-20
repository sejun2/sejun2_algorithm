class Solution {
        fun solution(n: Int, computers: Array<IntArray>): Int {
        // 0번부터 마지막 컴퓨터까지 dfs 를 돌려야한다.
        // 다만, 0번 돌리고나서 방문 정보를 보고 아직 방문되지않은 컴퓨터가 있다면, 해당 인덱스를 선택해서 dfs 다시.
        // 더이상 방문하지 않은 컴퓨터가 없을때까지 반복. 재귀
        // count 세서 반환

        var count = 0

        val visited = BooleanArray(computers.size) { false }

        while(visited.any { !it }){
            val index = visited.indexOfFirst { !it }
            
            println("index: $index")

            dfs(computers, visited, index)
            count++
        }

        return count
    }

    fun dfs(computers: Array<IntArray>, visited: BooleanArray, index: Int){
        visited[index] = true

        for(i in computers[index].indices){
            if(visited[i]) continue
            if(computers[index][i] != 1) continue

            dfs(computers, visited, i)
        }
    }
}
