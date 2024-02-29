package old01

import java.util.*

class SolutionT739 {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = Stack<Int>()
        val ans = IntArray(temperatures.size){it}
        for(i in temperatures.size-1 downTo 0){
            while(stack.isNotEmpty() && temperatures[i]<=stack.peek()){
                stack.pop()
            }
            ans[i] = if(stack.isEmpty()) 0 else
                stack.push(temperatures[i])
        }
        return ans

    }
}