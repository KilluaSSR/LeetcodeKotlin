import kotlin.math.max

class SolutionT1376 {
    lateinit var memo:IntArray
    var ans = 0
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        memo = IntArray(n){-1}
        for(employees in manager.indices){
            ans = max(ans,dp(employees, manager, informTime))
        }
        return ans
    }

    fun dp(employees:Int,manager: IntArray,informTime: IntArray):Int{
        if(manager[employees]==-1){
            return informTime[employees]
        }
        if(memo[employees]!=-1){
            return memo[employees]
        }
        memo[employees] = informTime[employees]+dp(manager[employees], manager, informTime)
        return memo[employees]
    }
}
