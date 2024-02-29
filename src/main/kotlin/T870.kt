package old01

import java.util.PriorityQueue
class SolutionT870 {
    fun advantageCount(nums1: IntArray, nums2: IntArray): IntArray {
        var left = 0
        var right = nums1.size-1
        nums1.sort()
        var ans = IntArray(nums1.size)
        val ids = nums2.indices // 获取nums2的下标数组
            .sortedBy { nums2[it] } // 根据nums2中的值对下标进行排序
            .toIntArray()
       for (items in nums1.indices){
           if(nums1[items]>nums2[ids[left]]){
               ans[ids[left++]] = nums1[items]
           }
           else{
                ans[ids[right--]] = nums1[items]
           }
       }
        return ans
    }
}

fun main() {
    SolutionT870().advantageCount(intArrayOf(2,7,11,15), intArrayOf(1,10,4,11))
}