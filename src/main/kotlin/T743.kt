import java.util.*

class SolutionT743 {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val graph = Array(n+1){ mutableListOf<IntArray>()}
        for(items in times){
            val from = items[0]
            val to = items[1]
            val weight = items[2]
            graph[from].add(intArrayOf(to,weight))
        }
        val distTo = dj(k,graph)
        var res = 0
        for(i in 1 until distTo.size){
            if(distTo[i]==Int.MAX_VALUE)return -1
            res = res.coerceAtLeast(distTo[i])
        }
        return res
    }
    private fun dj(start:Int, graph: Array<MutableList<IntArray>>):Array<Int>{
        val size = graph.size
        val distTo = Array(size){Int.MAX_VALUE}
        val priorityQueue = PriorityQueue{a:StateX,b:StateX->a.distFromStart-b.distFromStart}
        distTo[start]=0
        priorityQueue.offer(StateX(start,0))
        while (priorityQueue.isNotEmpty()){
            val current = priorityQueue.poll()
            val currID = current.ID
            val currDis = current.distFromStart
            if(distTo[currID]<currDis)continue
            for (neighbors in graph[currID]){
                val next = neighbors[0]
                val nextDis = distTo[currID]+neighbors[1]
                if(distTo[next]>nextDis){
                    distTo[next] = nextDis
                    priorityQueue.offer(StateX(next,distTo[next]))
                }
            }
        }
        return distTo

    }
}
