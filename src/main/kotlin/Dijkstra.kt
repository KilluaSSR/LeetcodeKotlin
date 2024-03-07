import java.util.*
data class State(var ID:Int,var distFromStart:Int = Int.MAX_VALUE)
class Dijkstra {

    fun dijkstra(start:Int,graph:Array<MutableList<IntArray>>):Array<Int>{
        val size = graph.size
        val distTo = Array<Int>(size){Int.MAX_VALUE}
        val pq = PriorityQueue{a:State,b:State->a.distFromStart-b.distFromStart}
        pq.offer(State(start,0))
        distTo[start]=0
        while (pq.isNotEmpty()){
            val currentState = pq.poll()
            val currentID = currentState.ID
            val currentDistFromStart = currentState.distFromStart
            if(currentDistFromStart>distTo[currentID])continue
            for(neighbors in graph[currentID]){
                val nxtID = neighbors[0]
                val distToNxt = distTo[currentID]+neighbors[1]
                if(distTo[nxtID]>distToNxt){
                    distTo[nxtID]=distToNxt
                    pq.offer(State(nxtID,distToNxt))
                }
            }

        }
        return distTo
    }
}


