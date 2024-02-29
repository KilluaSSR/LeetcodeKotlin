package old01

class SolutionT274 {
    fun hIndex(citations: IntArray): Int {
        citations.sortDescending()
        val size = citations.size
        var ans = 0
        while (ans<size && citations[ans]>ans){
            ans++
        }
        return ans


    }
}