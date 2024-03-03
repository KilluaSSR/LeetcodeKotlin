package old01

import TreeNode
import java.util.Scanner

class SolutionT889 {
    private val hashMap : HashMap<Int,Int> = HashMap()
    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
        if(preorder.size == 1) return TreeNode(preorder[0])
        for(items in postorder.indices){
            hashMap[postorder[items]] = items
        }

        return build(preorder,0,postorder.size-1,postorder,0,postorder.size-1)
    }
    private fun build(preorder: IntArray,preStart:Int,preEnd:Int,postorder:IntArray,postStart:Int,postEnd:Int):TreeNode?{
        if(preStart>preEnd)return null
        if (preStart == preEnd) {
            return TreeNode(preorder[preStart]);
        }
        val rootVal = preorder[preStart]
        val leftRootVal = preorder[preStart+1]
        val index = hashMap[leftRootVal]!!
        val leftLength = index - postStart + 1
        val root = TreeNode(rootVal)
        root.left = build(preorder,preStart+1,preStart+leftLength,postorder,postStart,postStart+leftLength-1)
        root.right = build(preorder,preStart+leftLength+1,preEnd,postorder,index+1,postEnd)
        return root

    }
}

