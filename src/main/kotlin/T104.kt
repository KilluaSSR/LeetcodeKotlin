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
class SolutioT104{
    var depth = 0
    var res = 0
    fun maxDepth(root: TreeNode?): Int {
        dp(root)
        return res

    }
    fun dp(root: TreeNode?):Int{
        if(root == null) return 0
        var maxLDepth = dp(root.left)
        var maxRDepth = dp(root.right)
        res = Math.max(maxLDepth,maxRDepth)+1
        return res
    }
}