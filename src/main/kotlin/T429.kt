package old01

import Node
import java.util.Queue

class SolutionT429 {
    fun levelOrder(root: Node?): List<List<Int>> {
        if(root == null) return listOf()
        val answer = ArrayList<List<Int>>()
        val queue : Queue<Node> = java.util.ArrayDeque()
        queue.add(root)

        while (queue.isNotEmpty()){
            val size = queue.size
            val list = ArrayList<Int>(size)
            repeat(size){
                val currentNode = queue.poll()
                list.add(currentNode.`val`)
                for (everChild in currentNode.children){
                    queue.add(everChild)
                }
            }
            answer.add(list)
        }
        return answer
    }
}