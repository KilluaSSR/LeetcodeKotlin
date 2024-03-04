class UnionFind(n:Int){
    //Union func: union root nodes
    //Connected func: is connected
    //find func: find root
    //size: size
    //parent: parent
    //count: N 连通分量数量

    val size = Array(n){1}
    private val parent = Array(n){ i->i}
    private var count = n
    fun union(p:Int,q:Int){
        val rootP = find(p)
        val rootQ = find(q)
        if (rootQ==rootP)return
        if (size[rootQ]>size[rootP]){
            parent[rootP] = rootP
            size[rootQ]+=size[rootP]
        }else{
            parent[rootQ]=rootP
            size[rootP]+=size[rootQ]
        }
        count--
    }

    fun connected(p:Int,q:Int) = find(p)==find(q)
    private fun find(x:Int):Int{
        if (parent[x]!=x){
            parent[x] = find(parent[x])
        }
        return parent[x]
    }
}





















