package old01

import com.sun.source.tree.Tree

class SolutionT105 {
    val hashMap = HashMap<Int,Int>()
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        for(items in inorder.indices){
            hashMap[inorder[items]] = items
        }
        return build(preorder,0,preorder.size-1,inorder,0,preorder.size-1)


    }
    fun build(preorder: IntArray,preStart:Int,preEnd:Int,inorder: IntArray,inStart:Int,inEnd:Int):TreeNode?{
        if(preStart>preEnd) return null
        val startRoot = preorder[preStart]
        val indexInInorder = hashMap[startRoot]!!
        val length = indexInInorder - inStart
        val nodeRoot = TreeNode(startRoot)
        nodeRoot.left = build(preorder,preStart+1,preStart+length,inorder,inStart,indexInInorder-1)
        nodeRoot.right = build(preorder,preStart+length+1,preEnd,inorder,indexInInorder+1,inEnd)
        return nodeRoot
    }

}
//root｜     LEFT       ｜     RIGHT
//Left             ｜root｜      Right