var answer = Int.MAX_VALUE

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
    // 총 송전탑개수
    val w = wires.size + 1

    // 간선을 하나씩 제거
    // 제거한 간선으로부터 dfs
    // dfs 로 도달한 count 세기
    // abs(w - count)
    // answer = minOf(answer, abs(w - count))

    val wireList = wires.toList() as MutableList<IntArray>

    for (i in wireList.indices) {
        val removed = wireList.removeAt(i)

        val visited = BooleanArray(w+1) { false }

        // 인접리스트로 간선 변환
        val graph = Array<MutableList<Int>>(w+1){
            mutableListOf<Int>()
        }

        // 인접리스트 생성
        for((x, y) in wireList){
            graph[x].add(y)
            graph[y].add(x)
        }

        // 시작은 index 1 으로 고정.
        val index = 1

        dfs(graph, visited, index)

        val visitCount = visited.count { it }
        val unvisitCount = w - visitCount
        
        println("visitCount: $visitCount")
        
        
        answer = minOf(Math.abs(visitCount - unvisitCount), answer)


        wireList.add(i, removed)
    }

    return answer
}

fun dfs(graph: Array<MutableList<Int>>, visited: BooleanArray, index: Int){
    println("visit $index")
    
    visited[index] = true

    for(x in graph[index]){
        if(visited[x])  continue

        dfs(graph, visited, x)
    }
}
}