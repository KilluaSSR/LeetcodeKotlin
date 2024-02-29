import java.util.LinkedList

class SolutionT997 {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val not : HashSet<Int> = HashSet()
        val yes : LinkedList<Int> = LinkedList()
        var c = -1
        for(people in trust[0]){
            not.add(people)
        }
        if(not.size == n)return -1
        for(i in 1..n){
            if( not.contains(i)) {continue}
            c = i
        }
        for(i in trust.indices){
            if(trust[i][1] == c){
                yes.add(i)
            }
        }
        if(yes.size == n-1){
            return c
        }
        return -1
    }
}