package old01

class Solution {
    var sum = 0
    fun convertBST(root: TreeNode?): TreeNode? {
        build(root)
        return root

    }
    fun build(root: TreeNode?){
        if(root == null)return
        build(root.right)
        sum+=root.`val`
        root.`val` = sum
        build(root.left)

    }
}