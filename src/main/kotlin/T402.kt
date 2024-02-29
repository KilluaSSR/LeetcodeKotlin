package old01

import java.util.*
import kotlin.collections.ArrayDeque

class SolutionT402 {
    fun removeKdigits(num: String, k: Int): String {
        if (num.length<=k)return "0"
        val queue : ArrayDeque<Char> = ArrayDeque()
        queue.add(num[0])
        val sb = StringBuilder()
        var times = k
        for(chars in 1..<num.length){
            if(times>0){
                if(queue.last()<num[chars]){
                    queue.addLast(num[chars])
                }else{
                    while(queue.isNotEmpty() && queue.last()>num[chars] && times>0){
                        queue.removeLast()
                        times--
                    }
                    queue.addLast(num[chars])
                }
            }else{
                queue.addLast(num[chars])
            }
        }
        for (i in 0..num.length-1-times){
            sb.append(queue.removeFirst())
        }
        return sb.toString()
    }
}