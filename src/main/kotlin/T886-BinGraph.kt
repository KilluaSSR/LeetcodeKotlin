class SolutionT886 {
    private var ok = true
    private lateinit var color: Array<Boolean>
    private lateinit var visited : Array<Boolean>
    fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
        val graph = buildGraph(n, dislikes)
        visited = Array(n+1){false}
        color = Array(n+1){false}
        for(i in 1..n){
            if(!visited[i]){
                traverse(graph, i)
            }
        }
        return ok
    }
    fun buildGraph(n:Int,dislikes: Array<IntArray>):Array<MutableList<Int>>{
        val graph = Array(n+1){ mutableListOf<Int>()}
        for (edges in dislikes){
            val p = edges[0]
            val q = edges[1]
            graph[p].add(q)
            graph[q].add(p)
        }
        return graph
    }

    private fun traverse(graph: Array<MutableList<Int>>, i: Int) {
        if (!ok)return
        visited[i] = true
        for(v in graph[i]){
            if(!visited[v]){
                color[v] = !color[i]
                traverse(graph,v)
            }else{
                if(color[v] == color[i]) {
                    ok = false
                    return
                }
            }

        }

    }
}