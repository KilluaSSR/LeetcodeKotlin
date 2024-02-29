package old01

class SolutionT438 {
    fun findAnagrams(s: String, p: String): List<Int> {
        val need = HashMap<Char,Int>()
        val window = HashMap<Char,Int>()
        var answer  = mutableListOf<Int>()
        var left = 0
        var right = 0
        var valid = 0
        for(items in p){
            need.put(items,need.getOrDefault(items,0)+1)
        }
        while(right<s.length){
            val c = s[right]
            right++
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1)
                if (need[c]?.equals(window[c])==true){
                    valid++
                }
            }
            while (right- left>=p.length){
                val d = s[left]
                if(valid == need.size){
                    answer.add(left)
                }
                left++
                if(need.containsKey(d)){
                    if(need.get(d)?.equals(window.get(d))==true){
                        valid--
                    }
                    window.put(d,window.getOrDefault(d,0)-1)
                }
            }

        }
        return answer

    }
}

fun main() {
    println(SolutionT438().findAnagrams("cbaebabacd", "abc"))
}