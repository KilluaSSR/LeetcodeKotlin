import java.util.PriorityQueue

class SolutionT871 {
    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val pq = PriorityQueue<Int>{a,b->b-a}
        var passed = 0
        var available = startFuel
        var index = 0
        var ans = 0
        val n = stations.size

        while(passed<target){
            if(available==0){
                if(pq.isNotEmpty()){
                    available += pq.poll()
                    ans++
                }else{
                    return -1
                }
            }
            passed+=available
            available=0
            if (index<n && stations[index][0]<=passed){
                pq.add(stations[index][1])
                index++
            }
        }
        return ans
    }
}