package old01

class SolutionT230 {
    var m = 0
    var ans = -1
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        calc(root,k)
        return ans
    }
    fun calc(root:TreeNode?, k:Int){
        if(root == null) return
        calc(root?.left,k)
        m++
        if(m==k){
            ans = root.`val`
        }
        calc(root?.right,k)
    }
}