import kotlin.math.max

class SolutionT135 {
    fun candy(ratings: IntArray): Int {
        if(ratings.size==1) return 1
        if (ratings.size==2){
            if(ratings[0]!=ratings[1]){
                return 3
            }else{
                return 2
            }
        }
        val ans = Array(ratings.size){1}
        if(ratings[0]>ratings[1]){
            ans[0]++
        }
        for (i in 1 until ratings.size){
            if (ratings[i]>ratings[i-1]){
                ans[i] = ans[i-1]+1
            }
        }
        for(i in ratings.size-2 downTo 0){
            if (ratings[i]>ratings[i+1]){
                ans[i] = max(ans[i],ans[i+1]+1)
            }
        }
        return ans.sum()
    }
}

fun main() {
    println(SolutionT135().candy(intArrayOf(1,0,2,23,9,1,3,4,0)))
}