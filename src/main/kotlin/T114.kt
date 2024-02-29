package old01

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class SolutionT114 {
    fun flatten(root: TreeNode?): Unit {
        if(root == null) return
        flatten(root.left)
        flatten(root.right)
        var left = root.left
        var right = root.right
        root.right = left
        root.left = null
        var current = root
        while(current?.right!=null){
            current = current.right
        }
        current?.right = right

    }
    
    
}