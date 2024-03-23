import kotlin.math.max

class SolutionT53 {
    fun maxSubArray(nums: IntArray): Int {
        val dp = IntArray(nums.size){Int.MIN_VALUE}
        var maxV = nums[0]
        if(nums.size==1)return nums[0]
        dp[0] = nums[0]
        for(i in 1..<nums.size){
            if(dp[i-1]<=0){
                dp[i] = nums[i]
            }else{
                dp[i] = dp[i-1] + nums[i]
            }
            maxV = max(maxV,dp[i])
        }
        return maxV

    }
}