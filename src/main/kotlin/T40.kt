fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val ans : MutableList<List<Int>> = ArrayList()
    val board : MutableList<Int> = ArrayList()
    val used = Array(candidates.size){false}
    candidates.sort()
    backtrackt40(ans,board,target,candidates,0,used)
    return ans
}

fun backtrackt40(ans: MutableList<List<Int>>, board: MutableList<Int>, target: Int, candidates: IntArray, index: Int,used:Array<Boolean>) {
    if(target==0){
        ans.add(ArrayList(board))
    }
    if(target>0){
        for (i in index until candidates.size ){
            if (used[i]){
                continue
            }
            if(i>index&&candidates[i]==candidates[i-1]){
                continue
            }
            board.add(candidates[i])
            used[i] = true
            backtrackt40(ans, board, target-candidates[i], candidates, i+1, used)
            board.removeLast()
            used[i] =false
        }
    }
}
fun main() {
    println(combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
}