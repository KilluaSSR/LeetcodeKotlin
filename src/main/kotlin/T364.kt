import kotlin.math.max

class SolutionT364 {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        envelopes.sortWith(compareBy ( {it[0]},{-it[1]}))
        val dp = IntArray(envelopes.size){1}
        for(i in dp.indices){
            for(j in 0 until i){
                if(envelopes[i][2]>envelopes[j][2]){
                    dp[i] = max(dp[i],dp[j]+1)
                }
            }
        }
        return dp.max()
    }
}