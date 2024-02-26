import java.util.*
import kotlin.collections.ArrayList

class SolutionT103 {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if(root == null) return listOf()
        val queue : Queue<TreeNode> = java.util.ArrayDeque()
        val answer = ArrayList<List<Int>>()
        queue.add(root)
        while(queue.isNotEmpty()){
            val size = queue.size
            val list = ArrayList<Int>(size)
            repeat(size){
                val node = queue.poll()
                node?.`val`?.let { list.add(it) }
                node?.left?.let { queue.add(it) }
                node?.right?.let { queue.add(it) }
            }
            if(answer.size%2==0){
                answer.add(list)
            }else{
                answer.add(list.reversed())
            }
            
        }
        return answer

    }
}