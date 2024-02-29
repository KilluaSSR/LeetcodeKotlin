package old01

class SolutionT456 {
    fun find132pattern(nums: IntArray): Boolean {
        if(nums.size<3)return false
        if(nums.size==3){if(nums[2]>nums[1]&&nums[1]>nums[0])return true else return false}
        val queue = java.util.ArrayDeque<Int>()
        val size = nums.size
        var k = Int.MIN_VALUE
        for(num in size-1 downTo  0){
            if(nums[num]<k)return true
            if(queue.isNotEmpty() && queue.peekLast()<nums[num]){
                k = queue.removeLast()
            }
            queue.addLast(nums[num])
        }
        return false
    }
}