class SolutionT26 {
    fun removeDuplicates(nums: IntArray): Int {
        var slow = 0
        var fast = 1
        while(fast<nums.size){
            if(nums[fast]==nums[fast-1]){
                fast++
            }else{
                slow++
                nums[slow]=nums[fast]
                fast++
            }

        }
        for (i in nums){
            println(i)
        }
        return slow+1
    }
}

fun main() {

   SolutionT26().removeDuplicates(intArrayOf(1,2,2,3))
}