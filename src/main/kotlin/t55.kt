package org.example

import kotlin.math.max
import kotlin.math.min
import kotlin.comparisons.maxOf
class SolutionT55 {
    fun canJump(nums: IntArray): Boolean {
        var maxReach = nums[0]
        for(steps in nums.indices){
            if(steps>maxReach)return false
            maxReach = maxOf(maxReach,steps+nums[steps])
        }
        return false
    }
}
fun main(args: Array<String>) {
    println(SolutionT55().canJump(intArrayOf(2,0,0)))
}
