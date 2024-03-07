import java.util.PriorityQueue

class SolutionT1514 {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start_node: Int, end_node: Int): Double {
        val graph = Array(n){ mutableListOf<DoubleArray>()}
        for(edge in edges.indices){
            val from = edges[edge][0].toDouble()
            val to = edges[edge][1].toDouble()
            val prob = succProb[edge]
            graph[from.toInt()].add(doubleArrayOf(to,prob))
            graph[to.toInt()].add(doubleArrayOf(from,prob))
        }
        val distTo = dijkstra(start_node,graph)
        if(distTo[end_node]==0.0)return 0.0
        return distTo[end_node]
    }
    fun dijkstra(start:Int,graph: Array<MutableList<DoubleArray>>):Array<Double>{
        val size = graph.size
        val distTo = Array(size){0.0}
        distTo[start]=1.0
        val priorityQueue = PriorityQueue{ a:StateT1514, b:StateT1514->b.dis.compareTo(a.dis)}
        priorityQueue.offer(StateT1514(start,1.0))
        while (priorityQueue.isNotEmpty()){
            val cur = priorityQueue.poll()
            val curID = cur.curID
            val curDis = cur.dis
            if(distTo[curID]>curDis)continue
            for(neighbors in graph[curID]){
                val nxt = neighbors[0]
                val nxtProb = neighbors[1]*distTo[curID]
                if(distTo[nxt.toInt()]<nxtProb){
                    distTo[nxt.toInt()] = nxtProb
                    priorityQueue.offer(StateT1514(nxt.toInt(),nxtProb))
                }
            }
        }
        return distTo
    }
    data class StateT1514(val curID:Int,val dis:Double)
}

fun main() {
    println(SolutionT1514().maxProbability(5, arrayOf(intArrayOf(1,4), intArrayOf(0,4), intArrayOf(0,3  ), intArrayOf(2,3)), doubleArrayOf(0.37,0.17,0.93,0.23,0.39,0.04),3,4))
}