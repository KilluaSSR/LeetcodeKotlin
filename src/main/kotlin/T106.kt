package old01

import TreeNode

class SolutionT106 {
    private val hashMap : HashMap<Int,Int> = HashMap()
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        for(items in inorder.indices){
            hashMap[inorder[items]] = items
        }
        return build(inorder,0,inorder.size-1,postorder,0,postorder.size-1)
    }
    private fun build(inorder:IntArray, inStart:Int, inEnd:Int, postorder: IntArray, postStart:Int, postEnd:Int):TreeNode?{
        if(postStart>postEnd) return null
        val rootIndex = postorder[postEnd]
        val index = hashMap[rootIndex]!!
        val root = TreeNode(rootIndex)
        val leftSize = index - inStart
        root.left = build(inorder,inStart,index-1,postorder,postStart,leftSize + postStart-1)
        root.right = build(inorder,index+1,inEnd,postorder,leftSize+1,postEnd-1)
        return root
    }
}

//
//输入：inorder = [9,   3,   15,20,7], postorder = [9      ,15, 7,20,    3]
//输出：[3,9,20,null,null,15,7]