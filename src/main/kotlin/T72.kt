import kotlin.math.min

class SolutionT72 {
    lateinit var memo:Array<IntArray>
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length
        memo = Array(m){ IntArray(n){-99} }
        return dp(word1,word2,m-1,n-1)
    }

    private fun dp(word1: String, word2: String, m: Int, n: Int): Int {
        if(m<0)return n+1
        if(n<0)return m+1
        if(memo[m][n]!=-99) return memo[m][n]
        if(word1[m]==word2[n])return dp(word1, word2, m-1, n-1)
        memo[m][n] =  min(
            dp(word1, word2, m-1, n)+1,
            min(
                dp(word1, word2, m, n-1)+1,
                dp(word1, word2, m-1, n-1)+1
            )
        )
        return memo[m][n]
    }

}

