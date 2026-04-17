class Solution {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var count:Int = 0
        
        for(i in schedules.indices){
           var tmpStartday = startday
           for(j in timelogs[i].indices) {
               if(tmpStartday == 6 || tmpStartday == 7) {
               		if(j == timelogs[i].size - 1) count++
               	    tmpStartday++
               		if(tmpStartday >7) tmpStartday = 1
                    continue
               }
               
               if(!isValid(schedules[i], timelogs[i][j])) break
             
              
               if(j == timelogs[i].size - 1) count++
               
               tmpStartday++
               if(tmpStartday >7) tmpStartday = 1
           }
        }
        
        return count
    }
    
    fun isValid(s: Int, arrived: Int): Boolean{
		var sHour: Int        
        var sMinutes: Int
        
        var aHour: Int
        var aMinutes: Int
        
        sHour = s/100
        sMinutes = s%100
        
        aHour = arrived/100
        aMinutes = arrived%100
        
        if(sHour > aHour){
            return true
        }
        
        if(sHour == aHour){
           if(aMinutes - sMinutes <= 10){
           		return true
           }
        }
        
        if(aHour  == sHour + 1){
            if(sMinutes + 10 -60 >= aMinutes){
                return true
            }
        }
     
        return false;
    }
}