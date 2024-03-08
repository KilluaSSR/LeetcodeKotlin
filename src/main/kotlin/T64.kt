class SolutionT64 {
    lateinit var memo : Array<IntArray>
    fun minPathSum(grid: Array<IntArray>): Int {
        memo = Array(grid.size*grid[0].size){ IntArray(grid[0].size){-666} }
        return dp(grid.size,grid[0].size,grid)
    }
    fun dp(m:Int,n:Int,grid: Array<IntArray>):Int{
        if(m==0&&n==0)return grid[0][0]
        if(m<0||n<0)return Int.MAX_VALUE
        if(memo[m][n]!=-666)return memo[m][n]
        memo[m][n] = Math.min(dp(m-1,n,grid),dp(m,n-1,grid))+grid[m][n]
        return memo[m][n]
    }
}