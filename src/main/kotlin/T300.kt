
import java.util.*
import kotlin.math.max

class SolutionT300{
    fun lengthOfLIS(nums: IntArray): Int {

        val dp = Array(nums.size){1}
        for(i in nums.indices){
            for(j in 0 until i){
                if(nums[i]>nums[j]){
                    dp[i] = max(dp[i],dp[j]+1)
                }
            }
        }
        return dp.max()
    }

}

fun main() {
    println(SolutionT300().lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3)))
}