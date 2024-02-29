package old01

class SolutionT1094 {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        if(trips[0][0]>capacity)return false
        var peopleNumbers = IntArray(1001)
        for(items in trips){
            val passengers = items[0]
            val start = items[1]
            val end = items[2]
            peopleNumbers[start]+=passengers
            peopleNumbers[end]-=passengers
        }
        for(stations in 1..1000){
            peopleNumbers[stations] = peopleNumbers[stations-1]+peopleNumbers[stations]
            if(peopleNumbers[stations]>capacity)return false
        }
        return true
    }
}
fun main() {
    println(SolutionT1094().carPooling(arrayOf(intArrayOf(2,1,5), intArrayOf(3,3,7)),5)
    )
}
