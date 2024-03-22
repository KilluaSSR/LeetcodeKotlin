import java.util.LinkedList

class SolutionT1315 {
    var sum = 0
    fun sumEvenGrandparent(root: TreeNode?): Int {
        val MyQueue : java.util.Queue<TreeNode?> = LinkedList()
        var rootx = root
        MyQueue.offer(root)
        while (MyQueue.isNotEmpty()){
            val current = MyQueue.poll()
            MyQueue.offer(current?.left)
            MyQueue.offer(current?.right)
            if (current==null)continue
            if(current.`val`!!%2==0){
                if (current.left?.left!=null){
                    sum+= current.left!!.left!!.`val`!!
                }
                if (current.left?.right!=null){
                    sum+= current.left!!.right!!.`val`!!
                }
                if (current.right?.left!=null){
                    sum+= current.right!!.left!!.`val`!!
                }
                if (current.right?.right!=null){
                    sum+= current.right!!.right!!.`val`!!
                }
            }
        }
        return sum
    }

}