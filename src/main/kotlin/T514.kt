import kotlin.math.absoluteValue
import kotlin.math.min

class SolutionT514 {
    private val mapToIndex = HashMap<Char, MutableList<Int>>()
    private lateinit var memo: Array<IntArray>
    fun findRotateSteps(ring: String, key: String): Int {
        memo = Array(ring.length) { IntArray(key.length) { 0 } }
        for (index in ring.indices) {
            if (!mapToIndex.containsKey(ring[index])) {
                mapToIndex[ring[index]] = mutableListOf(index)
            } else mapToIndex[ring[index]]?.add(index)
        }
        return dp(ring, 0, key, 0)
    }

    private fun dp(ring: String, i: Int, key: String, j: Int): Int {
        if (j == key.length) return 0
        if (memo[i][j] != 0) return memo[i][j]
        val n = ring.length
        var res = Int.MAX_VALUE
        for (index in mapToIndex[key[j]]!!) {
            var d = (index - i).absoluteValue
            d = min(d, n - d)
            val subProblem = dp(ring, index, key, j + 1)
            res = min(res, 1 + subProblem + d)
        }
        memo[i][j] = res
        return res
    }
}

