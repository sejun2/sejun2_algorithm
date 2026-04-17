class Solution {
    fun solution(n: Int, w: Int, num: Int): Int {
        val totalLevel = getBoxLevel(n,w)
        val boxLevel = getBoxLevel(num,w)
        
        if(totalLevel == boxLevel) return 1
        
        val boxIndex = getBoxIndex(num, w)
        
        val topBoxNum = getTopLevelBoxNumOfIndex(totalLevel,boxIndex,w)
        
            if(topBoxNum <= n){
                return totalLevel - boxLevel + 1
            }else{
                return totalLevel - boxLevel
            }
    }
    
    fun getBoxLevel(num:Int, w: Int): Int{
        val mods = num%w
        val quotient = num/w
        
        return if(mods == 0) quotient - 1 else quotient
    }
  
    fun getBoxIndex(num:Int, w:Int): Int{
        val mods = num%w
        
        val boxLevel = getBoxLevel(num, w)
        
        var index = -1
        
        if(boxLevel % 2 == 0){
            if(mods == 0){
                index = w - 1
            }else{
            	index = mods - 1
            }
        }else{
            if(mods == 0){
                index = 0 
            }else{
                index = w - mods
            }
        }
        
        println("index: $index")
        
        return index
    }
    
    fun getTopLevelBoxNumOfIndex(topLevel: Int, index: Int, w: Int) : Int{
        var boxNum = -1
        
        if(topLevel %2 == 0) {
            boxNum = ((topLevel+1) *  (w)) - (w - (index + 1))
        }else{
            boxNum = ((topLevel+1) * (w)) - (index)
        }
        
        println("boxNum: $boxNum")
        
        return boxNum
    }
    
    
    
    
    // 1. total level 구함
    // 2. total level 과 구하려고하는 상자의 level 이 같으면 1, 높으면 total level 에서 구하고자하는 상자의 index 에도 상자가 있는지 확인. 상자가 있다면 totallevel - 해당상자의 level; 상자가 없다면 total level - 해당상자의 level -1.
    
}