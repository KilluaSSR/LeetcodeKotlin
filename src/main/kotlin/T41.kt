import java.math.BigInteger

fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size
    var i = 0
    while (i < n) {
        while (nums[i] in 1..n && nums[nums[i] - 1] != nums[i]) {
            val temp = nums[nums[i] - 1]
            nums[nums[i] - 1] = nums[i]
            nums[i] = temp
        }
        i++
    }
    for (i in nums.indices) {
        if (nums[i] != i + 1) {
            return i + 1
        }
    }
    return n + 1
}
fun main() {
    println(firstMissingPositive(intArrayOf(3,4,-1,1)))
}
