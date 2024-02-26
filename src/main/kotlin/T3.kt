class SolutionT3 {
    fun lengthOfLongestSubstring(s:String): Int {
        var left = 0
        var longest = 0
        var right = 0
        val window = HashMap<Char,Int>()
        while(right<s.length){
            val c = s[right]
            right++
            window.put(c,window.getOrDefault(c,0)+1)
            while(window.get(c)!! >1){
                val d = s[left]
                left++
                window.put(d, window.get(d)!! -1)

            }
            longest = Math.max(longest,right-left)
        }
        return longest
    }

}

fun main() {
    println(SolutionT3().lengthOfLongestSubstring("abcabcabcbb"))
}