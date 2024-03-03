class TreeNode(var `val`: Int?) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun create(nodes: List<Int?>): TreeNode? {
            if (nodes.isEmpty() || nodes[0] == null) return null
            val root = TreeNode(nodes[0])
            val queue = ArrayDeque<TreeNode>()
            queue.add(root)
            var i = 1
            while (queue.isNotEmpty() && i < nodes.size) {
                val node = queue.removeFirst()
                if (nodes[i] != null) {
                    node.left = TreeNode(nodes[i])
                    queue.add(node.left!!)
                }
                i++
                if (i < nodes.size && nodes[i] != null) {
                    node.right = TreeNode(nodes[i])
                    queue.add(node.right!!)
                }
                i++
            }
            return root
        }
    }
}
class BinaryTreeTraverse {
    private var res = 0
    private var depth = 0
    fun maxDeep(root:TreeNode?){
        if(root == null) return
        depth ++
        if(root.left == null && root?.right == null) {
            res = res.coerceAtLeast(depth)
        }
        maxDeep(root.left)
        maxDeep(root.right)
        depth--
        if(depth==0){
            println(res)
        }

    }
}


/*class diameterOfBinaryTree{
    var maxDiameter = 0
    fun startPoint(root:TreeNode):Int{
        calculateDiameter(root)
        return maxDiameter
    }*/
  /*  fun calculateDiameter(root:TreeNode):Int{
        if(root == null)return 0

        var leftMax = root?.left?.let { calculateDiameter(it) }
        var rightMax = root?.right?.let { calculateDiameter(it) }
        var diameter = leftMax + rightMax
        maxDiameter = Math.max(maxDiameter, diameter)
        return 1+Math.max(leftMax, rightMax)
    }*/



/*}*/

fun main() {
        val root = TreeNode.create(listOf(3,9,20,null,null,15,7))
        BinaryTreeTraverse().maxDeep(root)
    }