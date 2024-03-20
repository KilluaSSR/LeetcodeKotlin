import kotlin.properties.Delegates

class SolutionT1319 {
    lateinit var size : IntArray
    private lateinit var parent : IntArray
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        var wires = 0
        var computersLinked = 1
        parent = IntArray(n){i->i}
        size = IntArray(n){1}
        for(computers in connections){
            if (isConnected(computers[0],computers[1])){
                wires++
                continue
            }
            UnionFind(computers[0],computers[1])
            computersLinked++
        }
        return if(wires+computersLinked>=n) n-computersLinked else -1

    }
    fun UnionFind(p:Int,q:Int){
        val rootP = findParent(p)
        val rootQ = findParent(q)
        if(rootP==rootQ)return
        if(size[rootP]>size[rootQ]){
            parent[rootQ] = parent[rootP]
            size[rootP]+=size[rootQ]
        }else{
            parent[rootP] = parent[rootQ]
            size[rootQ]+=size[rootP]
        }
    }
    fun findParent(x:Int):Int{
        if(parent[x]!=x){
            parent[x] = findParent(parent[x])
        }
        return parent[x]
    }
    fun isConnected(x:Int,y:Int) = findParent(x)==findParent(y)
}

fun main() {
    SolutionT1319().makeConnected(4, arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(1,2)))
}