//class SolutionT76 {
//    fun minWindow(s: String, t: String): String {
//        var left = 0
//        var right = 0
//        var valid = 0
//        var start = 0
//        var length = Int.MAX_VALUE
//        val need : HashMap<Char,Int> = HashMap()
//        val windows : HashMap<Char,Int> = HashMap()
//        for(chars in t){
//            need[chars] = need.getOrDefault(chars,0)+1
//        }
//        while(right<s.length){
//            var c = s[right]
//            right++
//            if(need.containsKey(c)){
//                windows[c] = windows.getOrDefault(c,0)+1
//                if(windows[c]?.equals(need[c])==true){
//                    valid++
//                }
//            }
//            while(valid == need.size){
//                if(right-left<length){
//                    start = left
//                    length = right - left
//                }
//                var d = s[left]
//                left++
//                if(need.containsKey(d)){
//                    if(windows[d]?.equals(need[d])==true){
//                        valid--
//                    }
//                    windows.get(d)?.minus(1)?.let { windows.put(d, it) }
//                }
//            }
//        }
//        return if (length == Int.MAX_VALUE)"" else s.substring(start,start+length)
//
//    }
//}
//
fun main() {
    println(SolutionT76().minWindow("eidbbhuoaooo","ab"))
}




class SolutionT76 {
    fun minWindow(s: String, t: String): String {
        var left = 0
        var right = 0
        var start = 0
        var valid = 0
        var length = Int.MAX_VALUE
        val need = HashMap<Char,Int>()
        val window = HashMap<Char,Int>()
        for(items in t){
            need[items] = need.getOrDefault(items,0)+1
        }
        while(right<s.length){
            var c = s[right]
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1)
                if(need.get(c)?.equals(window.get(c))==true){
                    valid++
                }
            }
            right++
            while(valid == need.size){
                if(right - left < length){
                    start = left
                    length = right - left
                }
                var d = s[left]
                left++
                if(need.containsKey(d)){
                    if (window[d]?.equals(need[d])==true){
                        valid--
                    }
                    window.get(d)?.minus(1)?.let { window.put(d,it) }
                }

            }


        }
        return if(length == Int.MAX_VALUE)"" else s.substring(start,start+length)
    }
}







































