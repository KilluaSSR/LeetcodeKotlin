package old01

class SolutionT179 {
    fun largestNumber(nums: IntArray): String {
        var ans = Array(nums.size) { i->nums[i] }
        ans.sortWith(Comparator{x,y -> (y+x).compareTo(x+y)})
        
        var res = StringBuilder()
        for(s in ans){
            res.append(s)
        }
        return res.toString()
    }
}

fun main(args: Array<String>) {
    println(SolutionT179().largestNumber(intArrayOf(3,30,34,5,9)))
}
