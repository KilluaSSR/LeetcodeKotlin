package old01

import java.util.*
import kotlin.collections.HashMap

class SolutionT496 {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val map = nxt(nums2)
        val hashMap : HashMap<Int,Int> = HashMap()
        val ans = IntArray(nums1.size)
        for(nums in nums2.indices){
            hashMap[nums2[nums]] = nums
        }
        for(items in nums1.indices){
            val a = hashMap[nums1[items]]
            ans[items] = map[a!!]
        }
        return ans

    }
    fun nxt(nums:IntArray):IntArray{
        val n = nums.size
        val res = IntArray(n)
        val stack = Stack<Int>()
        for(i in n-1 downTo 0){
            while(stack.isNotEmpty() && stack.peek()<=nums[i]){
                stack.pop()
            }
            res[i] = if(stack.isEmpty()) -1 else stack.peek()
            stack.push(nums[i])

        }
        return res
    }
}