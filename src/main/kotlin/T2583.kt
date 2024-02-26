import java.util.*
import kotlin.collections.ArrayList

class SolutionT2583 {
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        val queue : Queue<TreeNode?> = ArrayDeque()
        val sum = ArrayList<Long>()
        queue.offer(root)
        while(queue.isNotEmpty()){
            val levelSum = ArrayList<TreeNode>(queue)
            queue.clear()
            val current :Long = 0
            for(items in levelSum){
                items.`val`?.let { current.plus(it.toLong()) }
                queue.add(items?.left)
                queue.add(items?.right)
            }
            sum.add(current)
        }
        if(sum.size<k)return -1
        sum.sort()
        return sum[sum.size-k]
    }
}
