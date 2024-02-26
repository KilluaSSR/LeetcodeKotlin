import java.util.*

class SolutionT101 {
    fun isSymmetric(root: TreeNode?): Boolean {
        if(root == null ||(root.left == null && root.right == null)) return true
        val list : LinkedList<TreeNode?> =LinkedList()
        list.add(root.left)
        list.add(root.right)
        while (list.isNotEmpty()){
            var l = list.removeFirst()
            var r = list.removeFirst()
            if(l==null &&r==null) return true
            if(l==null||r==null||l.`val`!=r.`val`)return false
            list.add(l.left)
            list.add(r.right)
            list.add(l.right)
            list.add(r.left)
        }
        return true
    }

}