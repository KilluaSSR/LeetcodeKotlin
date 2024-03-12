
fun solveNQueens(n: Int): List<List<String>> {
    val res : MutableList<List<String>> = ArrayList()
    val board :MutableList<String> = ArrayList()
    for(i in 0 until n){
        val sb = StringBuilder()
        for(j in 0 until n){
            sb.append(".")
        }
        board.add(sb.toString())
    }
    backtrack(board,res,0)
    return res
}
fun backtrack(board: MutableList<String>,res:MutableList<List<String>>, row: Int) {
    if(board.size==row){
        res.add(ArrayList(board))
        return
    }
    val n = board.size
    for(i in 0 until n){
        if(!isValid(board,row,i)){
            continue
        }
        board[row] = StringBuilder(board[row]).apply { setCharAt(i, 'Q') }.toString()
        backtrack(board, res, row + 1)
        board[row] = StringBuilder(board[row]).apply { setCharAt(i, '.') }.toString()
    }
}

fun isValid(board: List<String>, row: Int, col: Int): Boolean {
    val n = board.size

    /* 检查列是否有皇后互相冲突 */
    for (i in 0 until n) {
        if (board[i][col] == 'Q') {
            return false
        }
    }

    /* 检查右上方是否有皇后互相冲突 */
    run {
        var i = row - 1
        var j = col + 1
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false
            }
            i--
            j++
        }
    }
    /* 检查左上方是否有皇后互相冲突 */
    var i = row - 1
    var j = col - 1
    while (i >= 0 && j >= 0) {
        if (board[i][j] == 'Q') {
            return false
        }
        i--
        j--
    }

    return true
}
fun main() {
    println(solveNQueens(6))
}