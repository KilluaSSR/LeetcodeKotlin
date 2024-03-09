import kotlin.math.max
import kotlin.math.min

class SolutionT45 {
    lateinit var memo : Array<Int>
    fun jump(nums: IntArray): Int {
        if(nums.size==1)return 0
        memo = Array(nums.size){-99}
        dp(nums,0)
        return memo[0]
    }

    private fun dp(nums: IntArray, cur: Int): Int {
        if (cur>=nums.size || (nums[cur]==0&&cur<nums.size-1))return Int.MAX_VALUE
        if (cur == nums.size-1)return 0
        if (memo[cur]!=-99)return memo[cur]
        var res = Int.MAX_VALUE
        for(index in cur+1..minOf(nums[cur]+cur,nums.size-1)){
            val x = dp(nums,index)
            if(x!=Int.MAX_VALUE){
                res = min(res,x+1)
            }
        }
        memo[cur]=res
        return memo[cur]
    }
    fun jump2(nums: IntArray): Int {
        val size = nums.size
        var end = 0
        var maxP = 0
        var step = 0
        for(index in 0 until size-1){
            maxP = max(maxP,index+nums[index])
            if(end == index){
                end = maxP
                step++
            }
        }
        return step
    }
}

fun main() {
    println(SolutionT45().jump2(intArrayOf(5,9,3,2,1,0,2,3,3,1,0,0)))
}