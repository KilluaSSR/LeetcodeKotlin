package old01
import kotlin.math.max

class SolutionT318 {
    fun maxProduct(words: Array<String>): Int {
        val check = Array<Int>(words.size){0}
        for (wordIndices in words.indices){
            for(character in words[wordIndices]){
                val x = character-'a'
                check[wordIndices] = check[wordIndices] or (1 shl x)
            }

        }
        val n = words.size
        var ans = -1
        for (wordIndices in 0 until n){
            for (nextIndices in wordIndices+1 until n)
            if(check[wordIndices]and check[nextIndices]==0){
                ans = (words[wordIndices].length * words[nextIndices].length).coerceAtLeast(ans)
            }
        }
        return ans
    }

}

fun main() {
    SolutionT318().maxProduct(arrayOf("abcw","cde"))
}