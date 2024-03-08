import kotlin.math.max
import kotlin.math.min

class SolutionT174 {
    lateinit var memo:Array<IntArray>
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val m = dungeon.size
        val n = dungeon[0].size
        memo = Array(m){IntArray(n){-9999}}
        return dp(dungeon,0,0)

    }
    fun dp(dungeon: Array<IntArray>,m:Int,n:Int):Int{
        if(m==dungeon.size-1&&n==dungeon[0].size-1)return if(dungeon[m][n]>=0) 1 else 1-dungeon[m][n]
        if(m==dungeon.size||n==dungeon[0].size)return Int.MAX_VALUE
        if(memo[m][n]!=-9999)return memo[m][n]
        val res = min(dp(dungeon,m+1,n),dp(dungeon,m,n+1)) - dungeon[m][n]
        memo[m][n] = if(res<=0) 1 else res
        return memo[m][n]
    }
}

