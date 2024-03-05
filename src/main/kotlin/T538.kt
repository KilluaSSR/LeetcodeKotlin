package old01

import TreeNode

class SolutionT538 {
    var sum = 0
    fun convertBST(root: TreeNode?): TreeNode? {
        build(root)
        return root

    }
    fun build(root: TreeNode?){
        if(root == null)return
        build(root.right)
        root.`val` = root.`val`!! + root.`val`!!
        root.`val` = sum
        build(root.left)

    }
}