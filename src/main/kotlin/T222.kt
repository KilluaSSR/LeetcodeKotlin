package old01

import TreeNode

class SolutionT222 {
    fun countNodes(root: TreeNode?): Int {
        var left = root
        var right = root
        var lh = 0
        var rh = 0
        while(left!=null){
            left = left.left
            lh++
        }
        while(right!=null){
            right = right.right
            rh++
        }
        if(lh == rh) return Math.pow(2.0,lh.toDouble()).toInt()-1
        return 1+countNodes(root?.right)+countNodes(root?.left)

    }
}