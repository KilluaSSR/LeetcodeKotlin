package old01
import kotlin.math.max

class Solution {
    fun maxProduct(words: Array<String>): Int {
        val map: MutableMap<Int, Int> = HashMap()
        val length = words.size
        for (i in 0 until length) {
            var mask = 0
            val word = words[i]
            val wordLength = word.length
            for (j in 0 until wordLength) {
                mask = mask or (1 shl (word[j].code - 'a'.code))
            }
            if (wordLength > map.getOrDefault(mask, 0)) {
                map[mask] = wordLength
            }
        }
        var maxProd = 0
        val maskSet: Set<Int> = map.keys
        for (mask1 in maskSet) {
            val wordLength1 = map[mask1]!!
            for (mask2 in maskSet) {
                if ((mask1 and mask2) == 0) {
                    val wordLength2 = map[mask2]!!
                    maxProd = max(maxProd.toDouble(), (wordLength1 * wordLength2).toDouble()).toInt()
                }
            }
        }
        return maxProd
    }
}