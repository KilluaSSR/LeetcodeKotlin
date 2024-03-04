class UnionFind (n:Int){
    val size = Array(n){1}
    val parent = Array(n){i->i}
    var count = n
    fun union(p:Int,q:Int){
        val rootP = find(p)
        val rootQ = find(q)
        if(rootQ==rootP)return
        if(size[rootQ]>size[rootP]){
            parent[rootP] = rootQ
            size[rootQ]+=size[rootP]

        }else{
            parent[rootQ] = rootP
            size[rootP]+=size[rootQ]
        }
        count--
    }
    fun find(x:Int):Int{
        if(parent[x]!=x){
            parent[x] = find(parent[x])
        }
        return parent[x]
    }
    fun connected(p:Int,q:Int) = find(p)==find(q)
}