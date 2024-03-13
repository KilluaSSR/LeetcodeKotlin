import java.math.BigInteger

fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size
    var i:Int = 0
    while (i<n){
        if(nums[i] in 1..n && nums[nums[i]-1]!=nums[i]){
            val tmp = nums[nums[i]-1]
            nums[nums[i]-1] = nums[i]
            nums[i] = tmp
        }
        i++
    }
    for (k in nums.indices){
        if(nums[k]!=k+1){
            return k+1
        }
    }
    return n+1
}
fun main() {
    println(firstMissingPositive(intArrayOf(-2,-1,3,7,1,4)))
}
