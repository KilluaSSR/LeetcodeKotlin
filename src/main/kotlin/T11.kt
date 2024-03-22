import kotlin.math.max
import kotlin.math.min

class SolutionT11 {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size-1
        var ans = 0
        while(left<right){
            ans = max(ans,(min(height[left],height[right])*(right-left)))
            if(height[right]>height[left]){
                left++
            }else{
                right--
            }
        }
        return ans
    }
}