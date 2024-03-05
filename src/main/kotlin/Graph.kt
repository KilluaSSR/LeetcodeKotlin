

class Graph(n:Int){
    private val visited = Array(n){false}
    private val onPath = Array(n){false}
    private var hasCircle = false
    private fun buildGraph(items: Int, relationship: Array<IntArray>):Array<MutableList<Int>>{
        val graph = Array(items){ mutableListOf<Int>()}
        for(edges in relationship){
            val from = edges[1]
            val to = edges[0]
            graph[from].add(to)
        }
        return graph
    }
    fun main(items: Int, relationship: Array<IntArray>){
        val graph = buildGraph(items,relationship)
        for(item in 0 until items){
            traverse(graph,onPath,visited,item)
        }

    }

    private fun traverse(
        graph: Array<MutableList<Int>>,
        onPath: Array<Boolean>,
        visited: Array<Boolean>,
        item: Int
    ) {
        if (hasCircle||onPath[item]) return
        if(visited[item])return
        visited[item]=true
        onPath[item]=true
        for(v in graph[item]){
            if (!onPath[v]){
                traverse(graph, onPath, visited, v)
            }
        }
        onPath[item]=false
    }

}