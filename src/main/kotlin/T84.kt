import java.util.Deque
import kotlin.math.max

class SolutionT84{
    fun largestRectangleArea(heights: IntArray): Int {
        var length = heights.size
        val left = Array(length){-1}
        val right = Array(length){i->i}
        val queue = ArrayDeque<Int>()
        for(index in 0 until length){
            val h = heights[index]
            while (queue.isNotEmpty() && h <= heights[queue.last()]){
                queue.removeLast()
            }
            if (queue.isNotEmpty()){
                left[index] = queue.last()
            }
            queue.addLast(index)

        }
        queue.clear()
        for(index in length-1 downTo 0){
            val h = heights[index]
            while (queue.isNotEmpty() && h <= heights[queue.last()]){
                queue.removeLast()
            }
            if (queue.isNotEmpty()){
                right[index] = queue.last()
            }
            queue.addLast(index)
        }
        var ans = 0
        for(i in heights.indices){
           ans = max(ans,heights[i]*(right[i]-left[i]-1))
        }
        return ans

    }
}