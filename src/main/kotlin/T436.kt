package old01

class SolutionT436 {
    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        val hashMap: HashMap<Int,Int> = HashMap()
        intervals.forEachIndexed{index, ints -> hashMap[ints[0]]=index }
        val sortedByStart = intervals.map { it[0] }.sorted()
        var ans = IntArray(intervals.size){-1}
        val size = intervals.size

        for(eachIndex in intervals.indices){
            val target = intervals[eachIndex][1]
            var left = 0
            var right = size -1
            while (left<=right){
                val mid = left+(right-left)/2
                if(sortedByStart[mid]>=target){
                    right = mid-1
                }else{
                    left = mid+1
                }
            }
            if(left<size){
                ans[eachIndex] = hashMap[sortedByStart[right+1]]!!
            }
        }
        return ans
    }
}