import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList

class SolutionT102 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if(root == null) return listOf()
        val queue : Queue<TreeNode> = java.util.ArrayDeque()
        var answer = ArrayList<List<Int>>()
        queue.add(root)
        while(queue.isNotEmpty()){
            val size = queue.size
            val list = ArrayList<Int>(size)
            repeat(size){
                val node = queue.poll()
                node.`val`?.let { it1 -> list.add(it1) }
                node.left?.let { it1->queue.add(it1) }
                node?.right?.let{it2->queue.add(it2)}
            }
            answer.add(list)
        }
        return  answer

    }


}

