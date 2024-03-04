class SolutionT130 {

    fun solve(board: Array<CharArray>): Unit {
        val row = board.size
        val col = board[0].size
        val uf = UnionFind((row * row).coerceAtLeast(col * col) + row.coerceAtLeast(col))
        val dummy = row*col
        for(i in board.indices){
            for(j in board[0].indices){
                if (board[i][j]=='O'){
                    val isEdge = i==0||j==0||i==row-1||j==col-1
                    if(isEdge){
                        uf.union(dummy,node(i,j,col))
                    }else{
                        if(i-1>=0 && board[i-1][j] == 'O'){
                            uf.union(node(i-1,j,col),node(i,j,col))
                        }
                        if(j-1>=0 && board[i][j-1] == 'O'){
                            uf.union(node(i,j,col),node(i,j-1,col))

                        }
                        if(i+1<=row && board[i+1][j] == 'O'){
                            uf.union(node(i+1,j,col),node(i,j,col))

                        }
                        if(j+1<=col && board[i][j+1] == 'O'){
                            uf.union(node(i,j,col),node(i,j+1,col))

                        }
                    }
                }
            }
        }
        for (i in board.indices){
            for(j in board[0].indices){
                val isEdge = i==0||j==0||i==row-1||j==col-1
                if (board[i][j]=='O'&&!uf.connected(node(i,j,col),dummy)&&!isEdge) board[i][j]='X'
            }
        }
    }
    fun node(i:Int,j:Int,col:Int) = i*col+j
}

