package old01

class SolutionT303NumArray(nums: IntArray) {
    var preSum = IntArray(nums.size+1)
    init {
        for(numbers in 1..nums.size){
            preSum[numbers] = preSum[numbers-1]+nums[numbers-1]
        }
    }
    fun sumRange(left: Int, right: Int): Int {
        return preSum[right+1]-preSum[left]
    }
}
