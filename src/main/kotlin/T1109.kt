package old01

class SolutionT1109 {
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int) {
        var df = IntArray(n)
        for(items in bookings){
            val start = items[0]
            val end = items[1]
            val seats = items[2]
            df[start-1]+=seats
            if(end<n)df[end]-=seats
        }
        for(i in 1..n-1){
            df[i] =df[i-1]+df[i]
        }
    }
}



fun main() {
     SolutionT1109().corpFlightBookings(arrayOf(intArrayOf(1,2,10), intArrayOf(2,3,20), intArrayOf(2,5,25)),5)

}
