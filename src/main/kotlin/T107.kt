package old01

import java.util.*
import kotlin.collections.ArrayList

class SolutionT107 {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        if(root == null) return listOf()
        val queue : Queue<TreeNode?> = ArrayDeque()
        val answer = ArrayList<List<Int>>()
        queue.add(root)
        while(queue.isNotEmpty()){
            val size = queue.size
            val list = ArrayList<Int>(size)
            repeat(size){
                val node = queue.poll()
                node?.`val`?.let { it1 -> list.add(it1) }
                queue.add(node?.left)
                queue.add(node?.right)
            }
            answer.add(list)
        }

        return answer.reversed()

    }
}

fun main() {

}