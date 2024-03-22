import kotlin.math.max
import kotlin.math.min

class SolutionT42 {
    fun trap(height: IntArray): Int {
        val n = height.size
        val memoLeft = IntArray(n){0}
        var curML = 0
        var curMR = 0
        val memoRight = IntArray(n){0}
        var sum = 0
        for (i in 1 until n){
            curML = max(curML,height[i-1])
            memoLeft[i] = curML
        }
        for(i in n-2 downTo 0){
            curMR = max(curMR,height[i+1])
            memoRight[i] =curMR
        }
        for(i in height.indices){
            if(min(memoRight[i], memoLeft[i]) - height[i]>0){ sum += min(memoRight[i], memoLeft[i]) - height[i] }
        }
        return sum
    }
}

fun main() {
    SolutionT42().trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1))
}