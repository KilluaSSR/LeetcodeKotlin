class SolutionT63 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1)return 0
        if (m==1&&n==1)return 1
        val dp = Array(m){IntArray(n) }
        var encounteredStoneTop = false
        var encounteredStoneLeft = false
        for(i in 0 until m){
            if(obstacleGrid[i][0]==1)encounteredStoneLeft=true
            dp[i][0] = if(encounteredStoneLeft)-1 else 1
        }
        for (i in 0 until n){
            if(obstacleGrid[0][i]==1)encounteredStoneTop=true
            dp[0][i] = if(encounteredStoneTop)-1 else 1
        }
        for(i in 1 until m){
            for(j in 1 until n){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=-1
                    continue
                }
                if(obstacleGrid[i-1][j]==1&&obstacleGrid[i][j-1]==1){
                    dp[i][j]=-1
                    continue
                }
                if(obstacleGrid[i-1][j]==1&&dp[i][j-1]==-1){
                    dp[i][j]=-1
                    continue
                }
                if(obstacleGrid[i][j-1]==1&&dp[i-1][j]==-1){
                    dp[i][j]=-1
                    continue
                }
                if(dp[i][j-1]==-1){
                    dp[i][j]= dp[i-1][j]
                    continue
                }
                if(dp[i-1][j]==-1){
                    dp[i][j]= dp[i][j-1]
                    continue
                }
                dp[i][j] = dp[i-1][j]+dp[i][j-1]
            }
        }
        return if(dp[m-1][n-1]<0) 0 else dp [m-1][n-1]
    }
}

fun main() {
    println(
        SolutionT63().uniquePathsWithObstacles(
            arrayOf(
                intArrayOf(0,1),
                intArrayOf(1,0)
            )
        )
    )
}