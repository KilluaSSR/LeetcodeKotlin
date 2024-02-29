package old01

import com.sun.source.tree.Tree

//class SolutionT654 {
//    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
//        return build(nums,0,nums.size-1)
//    }
//    private fun build(nums:IntArray, left:Int, right:Int):TreeNode?{
//        if(left>right)return null
//        var index = left
//        var max = nums[left]
//        for(items in left..right){
//            if ((nums[items]>max)){
//                max = nums[items]
//                index = items
//            }
//            val root = TreeNode(max)
//            root.left = build(nums,left,index-1)
//            root.right = build(nums,index+1,right)
//        }
//        return root
//
//    }
//}