import java.util.*

class SolutionT503 {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val stack = Stack<Int>()
        val size = nums.size
        val ans = IntArray(size)
        for(i in 2*size-1 downTo 0){
            while(stack.isNotEmpty() && stack.peek()<=nums[i%size]){
                stack.pop()
            }
            ans[i%size] = if(stack.isEmpty()) -1 else stack.peek()
            stack.push(nums[i%size])
        }
        return ans
    }
}

fun main() {
    println(SolutionT503().nextGreaterElements(intArrayOf(1, 2, 1)))
}