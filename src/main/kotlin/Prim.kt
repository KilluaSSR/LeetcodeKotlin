
import java.util.*


class Prim (
    private val graph: Array<List<IntArray>>
){
    private var inPrim : BooleanArray = BooleanArray(graph.size){false}
    private var weightSum = 0
    val pq = PriorityQueue{a:IntArray,b:IntArray->a[2]-b[2]}
    init {
        val size = graph.size

        cut(0)
        inPrim[0]=true
        while (pq.isNotEmpty()){
            val edge = pq.poll()
            val to = edge[1]
            val weight = edge[2]
            if (inPrim[to])continue
            cut(to)
            weightSum+=weight
            inPrim[to] = true
        }
    }

    private fun cut(i: Int) {
        for (edges in graph[i]){
            if (inPrim[edges[1]])continue
            pq.offer(edges)
        }
    }
    fun weight() = weightSum
    private fun all():Boolean{
        for(i in inPrim.indices){
            if(!inPrim[i])return false
        }
        return true
    }
}