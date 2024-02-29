package old01

class SolutionT567 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        var left = 0
        var right = 0
        var need = HashMap<Char,Int>()
        var window = HashMap<Char,Int>()
        var valid = 0
        var start = 0
        var length = Int.MAX_VALUE
        for(items in s1){
            need[items] = need.getOrDefault(items, 0)+1
        }
        while (right<s2.length){
            var c = s2[right]
            right++
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1)
                if(need[c]?.equals(window[c])==true){
                    valid++
                }
            }
            while(valid == need.size){
                var d = s2[left]

                if(right - left<length){
                    start = left
                    length = right-left
                }
                left++
                if(window.containsKey(d)){
                    if(window.get(d)?.equals(need.get(d))==true){
                        valid--
                    }
                    window[d]?.minus(1)?.let { window.put(d,it) }
                }
            }
        }
        return if(s2.substring(start,start+length).length == s1.length) true else false

    }
}
fun main() {
    println(SolutionT567().checkInclusion("ab", "eidbbhuobaooo"))
}