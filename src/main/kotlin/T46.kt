import java.util.LinkedList

class SolutionT46 {
    val res = mutableListOf<List<Int>>()
    fun permute(nums: IntArray): List<List<Int>> {
        val stack = mutableListOf<Int>()
        val used = Array(nums.size){false}
        traceback(nums,stack,used)
        return res
    }

    private fun traceback(nums: IntArray, stack: MutableList<Int>, used: Array<Boolean>) {
        if(stack.size==nums.size){
            res.add(LinkedList(stack))
        }
        for (i in nums.indices){
            if (used[i])continue
            used[i] = true
            stack.add(nums[i])
            traceback(nums, stack, used)
            used[i] = false
            stack.removeLast()
        }
    }
}

fun main() {
    println(SolutionT46().permute(intArrayOf(2, 3, 1)))
}