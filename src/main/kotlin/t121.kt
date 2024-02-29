package old01

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxValue = 0
        var minValue = Int.MAX_VALUE
        for(currentPrice in prices.indices){
            minValue = min(prices[currentPrice],minValue)
            maxValue = max(maxValue,prices[currentPrice]-minValue)

        }
        return maxValue
    }
}
class SolutionDP {
    fun maxProfit(prices: IntArray): Int {
        val len = prices.size
        if (len == 0) return 0
        val dp = Array(len) { IntArray(2) }
        dp[0][0] = -prices[0]
        dp[0][1] = 0
        for (i in 1 until len) {
            dp[i][0] = maxOf(dp[i - 1][0], -prices[i])
            dp[i][1] = maxOf(dp[i - 1][1], prices[i] + dp[i - 1][0])
        }
        return dp[len - 1][1]
    }
}

fun main(args: Array<String>) {
    println(Solution().maxProfit(intArrayOf(3,2,3,4,6,3,9)))
}