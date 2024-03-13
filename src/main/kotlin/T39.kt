fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val ans : HashSet<List<Int>> = HashSet()
    val board : MutableList<Int> = ArrayList()
    backtrackt39(ans,board,target,candidates)
    return ans.toMutableList()
}

fun backtrackt39(ans: HashSet<List<Int>>, board: MutableList<Int>,target: Int,candidates: IntArray) {
    if(board.sum()>target){
        return
    }
    if(board.sum()==target){
        ans.add(ArrayList(board).sorted())
    }
    for (j in candidates.indices){
        board.add(candidates[j])
        backtrackt39(ans, board, target, candidates)
        board.removeLast()
    }
}
fun main() {
    println(combinationSum(intArrayOf(2, 3, 5), 8))
}
