package old01

class SolutionT151 {
    fun reverseWords(s:String):String{
        val queue = ArrayDeque<String>()
        val words = s.trim().split("\\s+".toRegex())
        for(word in words.reversed()){
            queue.add(word)
        }
        return queue.joinToString(" ")
    }
    fun reverseWords1(s: String):String {
        var queue =  ArrayDeque<Char>()
        var str = s.trim().toCharArray()
        var sb = StringBuilder()
        var size = str.size
        for(c in str.indices){
            if(str[c]!=' '){
                queue.add(str[c])
            }
            if(c+1<size && str[c]==' ' && str[c+1]!= ' '){
                queue.add(str[c])
            }
            if (c+1<size && str[c]==' ' && str[c+1]== ' '){
                continue
            }
        }
        while(queue.isNotEmpty()){
            sb.append(queue.removeLast())
        }
        var ans = sb.toString().toCharArray()
        var start = 0
        var end = 0
        while (end<ans.size){
            while (end<ans.size && ans[end]!=' '){
                end++
            }
            reverse(ans,start,end-1)
            end++
            start = end
        }
        return String(ans)
 }
    fun reverse(s:CharArray,start:Int,end:Int){
        var a = start
        var b= end
        while(a<b){
            val temp = s[a]
            s[a] = s[b]
            s[b] = temp
            a++
            b--
        }
    }
}

fun main() {
    println(SolutionT151().reverseWords("a good   example"))
}