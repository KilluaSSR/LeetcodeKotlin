class SolutionT5{
    fun longestPalindrome(s: String): String {
        var ans = ""
        for(characters in s.indices){
            var s1 = ssubstring(s,characters,characters)
            var s2 = ssubstring(s,characters,characters+1)
            var longest = if(s1.length>s2.length)s1 else s2
            ans = if(ans.length>longest.length)ans else longest
        }
        return ans
    }
    fun ssubstring(s: String,k:Int,l:Int):String{
        var left = k
        var right = l
        while(left>=0&&right<s.length && s[left]==s[right]){
            left--
            right++
        }
        return s.substring(left+1,right)
    }
}

fun main() {
    print(SolutionT5().longestPalindrome("bb"))
}