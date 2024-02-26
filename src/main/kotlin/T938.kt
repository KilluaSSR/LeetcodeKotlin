class SolutionT938 {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        var ans = 0
        var r = root
        val queue : ArrayDeque<TreeNode?> = ArrayDeque()
        while(queue.isNotEmpty()||r!=null){
            while(r!=null){
                queue.add(r)
                r = r.left
            }
            r = queue.removeLast()
            if (r != null) {
                if(r.`val`!! in low..high){
                    ans+=r.`val`!!
                }
            }
            if (r != null) {
                r = r.right
            }
        }
        return ans
    }

}