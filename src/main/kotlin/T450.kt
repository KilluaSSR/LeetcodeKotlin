package old01

import TreeNode

class SolutionT450 {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if(root == null) return null
       if(root.`val`==key){
           if(root.left==null) return root.right
           if(root.right==null)return root.left
           val node = getMin(root.right)
           root.right = node?.`val`?.let { deleteNode(node,it) }
           node?.left = root.left
           node?.right = root.right


           return node

       }else if(root.`val`!! >key){
           root.left = deleteNode(root.left,key)
       }else{
           root.right = deleteNode(root.right,key)
       }
        return root


    }
    fun getMin(root: TreeNode?):TreeNode?{
        var node = root
        while(node?.left!=null){
            node = node.left
        }
        return node
    }




}