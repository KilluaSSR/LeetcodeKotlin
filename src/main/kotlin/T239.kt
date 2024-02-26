import java.util.*
import kotlin.collections.ArrayList


class MonotonicList {
    val maxQ:LinkedList<Int> = LinkedList()
    fun pop(n:Int){
        if(maxQ.isNotEmpty() && maxQ.first()==n){
            maxQ.removeFirst()
        }
    }
    fun push(n:Int){
        while(maxQ.isNotEmpty() && maxQ.last()<n){
            maxQ.removeLast()
        }
        maxQ.addLast(n)
    }
    fun max():Int=maxQ.first()
}
class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val maxQ = MonotonicList()
        val ans = ArrayList<Int>()
        for(i in nums.indices){
            if(i<k-1){
                maxQ.push(nums[i])
            }else{
                maxQ.push(nums[i])
                ans.add(maxQ.max())
                maxQ.pop(nums[i-k+1])
            }
        }
        return ans.toIntArray()
    }
}