class PreInner {
    private val hashMap:HashMap<Int,Int> = HashMap()
    fun constructFromPreInner(preorder: IntArray, inorder: IntArray): TreeNode? {
            for(indices in inorder.indices){
                hashMap[inorder[indices]] = indices
            }
        return build(preorder,0,preorder.size-1,inorder,0,inorder.size-1)
    }
    private fun build(preorder: IntArray,preStart:Int,preEnd:Int,inorder: IntArray,inStart:Int,inEnd:Int):TreeNode?{
        if(preStart>preEnd) return null
        val rootVal = preorder[preStart]
        val index = hashMap[rootVal]!!
        val length = index - preStart
        val root = TreeNode(rootVal)
        root.left=build(preorder,preStart+1,preStart+length,inorder,inStart,index-1)
        root.right=build(preorder,preStart+length+1,preEnd,inorder,index+1,inEnd)
        return root
    }
}
class InnerPost{
    private val hashMap:HashMap<Int,Int> = HashMap()
    fun constructFromInnerPost(postorder: IntArray, inorder: IntArray): TreeNode? {
        for(indices in inorder.indices){
            hashMap[inorder[indices]] = indices
        }
        return build(postorder,0,postorder.size-1,inorder,0,inorder.size-1)
    }
    private fun build(postorder: IntArray, postStart: Int, postEnd: Int, inorder: IntArray, inStart: Int, inEnd: Int): TreeNode? {
        val rootVal = postorder[postEnd]
        val index = hashMap[rootVal]!!
        val leftLength = index - inStart
        val root = TreeNode(rootVal)
        root.left = build(postorder,postStart,postStart+leftLength-1,inorder,inStart,index-1)
        root.right = build(postorder,postStart+leftLength,postEnd-1,inorder,index+1,inEnd)
        return  root
    }
}

class PrePost {
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