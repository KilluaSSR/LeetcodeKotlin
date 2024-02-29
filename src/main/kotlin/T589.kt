package old01
// Iterate
class SolutionT589Iter {
    fun preorder(root: Node?): List<Int> {
        if (root == null)return emptyList()
        val deque : ArrayDeque<Node?> = ArrayDeque()
        val answer = ArrayList<Int>()
        deque.add(root)
        while (deque.isNotEmpty()){
            val current = deque.removeFirstOrNull()
            current?.`val`?.let { answer.add(it) }
            if (current != null) {
                for(child in current.children.reversed()){
                    deque.add(child)
                }
            }
        }
        return answer
    }
}
fun main() {
    // 创建节点
    val root = Node(1)
    val child1 = Node(3)
    val child2 = Node(2)
    val child3 = Node(4)
    val grandchild1 = Node(5)
    val grandchild2 = Node(6)

    // 构建树结构
    child1.children = listOf(grandchild1, grandchild2) // child1 有两个子节点
    root.children = listOf(child1, child2, child3) // root 有三个子节点

    // 实例化SolutionT589Recu类并调用preorder方法
    val solution = SolutionT589Recu()
    val result = solution.preorder(root)

    // 打印先序遍历的结果
    println(result.joinToString(", ")) // 应该输出: 1, 2, 5, 6, 3, 4
}

//Recursion
class SolutionT589Recu {
    private val answer = ArrayList<Int>()
    fun preorder(root: Node?): List<Int> {
        if(root == null) return listOf()
        answer.add(root.`val`)
        root.children.forEach{ child->preorder(child)}
        return answer
    }

}