package old01

import TreeNode

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
class SolutionT226 {
    fun invertTree(root: TreeNode?): TreeNode? {
        reverse(root)
        return root
    }
    fun reverse(root:TreeNode?){
        if(root == null) return
        var temp = root.left
        root.left = root.right
        root.right = temp
        reverse(root.left)
        reverse(root.right)
    }
}