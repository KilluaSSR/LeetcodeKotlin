import kotlin.math.max

class SolutionT364 {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        envelopes.sortWith(compareBy ( {it[0]},{-it[1]} ) )
        val dp = Array(envelopes.size){1}
        for(i in dp.indices){
            for(j in 0 until i){
                if (envelopes[i][1]>envelopes[j][1]){
                    dp[i] = max(dp[i],i+dp[j])
                }
            }
        }
        return dp.max()
    }
}
