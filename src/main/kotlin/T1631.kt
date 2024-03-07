import java.time.MonthDay
import java.util.*
import kotlin.math.abs
import kotlin.math.absoluteValue

class SolutionT1631 {
    data class State(val x:Int,val y:Int,val dis:Int)
    val dis = arrayOf(intArrayOf(0,1), intArrayOf(0,-1), intArrayOf(-1,0), intArrayOf(1,0))
    fun getNeighbors(heights: Array<IntArray>, x:Int, y:Int):MutableList<IntArray>{
        val size = heights.size
        val length = heights[0].size
        val res = mutableListOf<IntArray>()
        for (dirs in dis){
            val xNew = x+dirs[0]
            val yNew = y+dirs[1]
            if(xNew<0||yNew<0||yNew>=length||xNew>=size)continue
            res.add(intArrayOf(xNew,yNew))
        }
        return res
    }
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val size = heights.size
        val length = heights[0].size
        val PriorityQueue = PriorityQueue{a:State,b:State->a.dis-b.dis}
        val disTo = Array(size){IntArray(length){Int.MAX_VALUE}}
        disTo[0][0]=0
        PriorityQueue.offer(State(0,0,0))
        while (PriorityQueue.isNotEmpty()){
            val cur = PriorityQueue.poll()
            val curX = cur.x
            val curY = cur.y
            val curDis = cur.dis
            if(curX==size-1&&curY==length-1)return curDis
            if(disTo[curX][curY]<curDis)continue
            for(neighbors in getNeighbors(heights,curX,curY)){
                val nextX = neighbors[0]
                val nextY = neighbors[1]
                val nextDis = disTo[curX][curY].coerceAtLeast((heights[nextX][nextY]-heights[curX][curY]).absoluteValue)
                if(disTo[nextX][nextX]>nextDis){
                    disTo[nextX][nextY] = nextDis
                    PriorityQueue.add(State(nextX,nextY,nextDis))
                }
            }
        }
        return -1

    }
}