fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val ans : MutableList<List<Int>> = ArrayList()
    val board : MutableList<Int> = ArrayList()
    backtrackt39(ans,board,target,candidates,0)
    return ans
}

fun backtrackt39(ans: MutableList<List<Int>>, board: MutableList<Int>,target: Int,candidates: IntArray,index:Int) {
    if(target==0){
        ans.add(ArrayList(board))
        return
    }
    if(target>0){
        for(i in index until candidates.size){
            board.add(candidates[i])
            backtrackt39(ans, board, target-candidates[i], candidates, i)
            board.removeLast()
        }
    }
}
fun main() {
    println(combinationSum(intArrayOf(2, 3, 5), 8))
}
