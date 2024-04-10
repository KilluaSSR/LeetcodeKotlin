class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = grid[0].size
        if (m==1&&n==1) return if(grid[0][0]=='1')1 else 0
        val sol = T200UnionFind(m*n)
        grid.indices.forEach{ rows->
            grid[0].indices.forEach { cols->
                if (grid[rows][cols]=='1'){
                    sol.count++
                }

            }

        }
        for(rows in grid.indices){
            for (cols in grid[0].indices){
                if(rows*cols!=0 && grid[rows][cols]=='1'){
                    if(grid[rows-1][cols]=='1'){
                        sol.union((rows-1)*n+cols,(rows)*n+cols)
                    }
                    if (grid[rows][cols-1]=='1'){
                        sol.union(rows*n+(cols-1),(rows)*n+cols)
                    }
                }else if(rows==0 && grid[rows][cols]=='1'){
                    if(cols>=1  && grid[rows][cols-1]=='1'){
                        sol.union(cols,cols-1)
                    }
                }else if (cols==0 && grid[rows][cols]=='1'){
                    if(rows>=1  && grid[rows-1][cols]=='1'){
                        sol.union((rows-1)*n,rows*n)
                    }
                }
            }
        }
        return sol.count
    }
}


class T200UnionFind(val n:Int){
    val size = Array(n){1}
    val parents = Array(n) { i->i }
    var count = 0
    fun find(x:Int):Int{
        if(parents[x]!=x){
            parents[x] = find(parents[x])
        }
        return parents[x]
    }
    fun union(x: Int, y: Int){
        val rootX = find(x)
        val rootY = find(y)
        if(rootX==rootY)return
        if(size[rootX]>size[rootY]){
            parents[rootY] = rootX
            size[rootX]+=size[rootY]
        }else{
            parents[rootX] = rootY
            size[rootY] += size[rootX]
        }
        count--
    }
    fun connected(x:Int,y:Int) = find(x)==find(y)
}