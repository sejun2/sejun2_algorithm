class Solution {
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        // 상하좌우로 대칭시켜서 일직선 연결했을때 가장 작은값
        
        val answer = IntArray(balls.size)
       
        
        
        for(i in balls.indices){
            var min = Int.MAX_VALUE
            
            // 아래
            if(!(startX == balls[i][0] && startY > balls[i][1])){
            	min = Math.min(getValue(startX, startY, balls[i][0], -balls[i][1]), min)
            }
            
            // 왼쪽
            if(!(startY == balls[i][1] && startX > balls[i][0])){
            	min = Math.min(getValue(startX, startY, -balls[i][0], balls[i][1]),min)
            }
            
            // 오른쪽
            if(!(startY == balls[i][1] && startX < balls[i][0])){
            	min = Math.min(getValue(startX, startY, balls[i][0] + (m-balls[i][0])*2, balls[i][1]), min)
            }
            
            // 위
            if(!(startX == balls[i][0] && startY < balls[i][1])){
            	min = Math.min(getValue(startX, startY, balls[i][0], balls[i][1]+(n-balls[i][1])*2),min)
            }
        
        	answer[i] = min
        }
        
        return answer
    }
    
    fun getValue(sx:Int, sy:Int, dx:Int, dy:Int): Int {
        return (Math.pow((sx-dx).toDouble(), 2.0) + Math.pow((sy-dy).toDouble(), 2.0)).toInt()
    }
}