package old01

import java.util.HashMap
import java.util.LinkedList

class SolutionT752{
    fun plus(s:String,j:Int):String{
        var ch = s.toCharArray()
        if(ch[j]=='9')ch[j]='0'
        ch[j] = ch[j]+1
        return String(ch)
    }
    fun minus(s:String,j:Int):String{
        var ch = s.toCharArray()
        if(ch[j]=='0')ch[j]='9'
        ch[j] = ch[j]-1
        return String(ch)
    }
    fun openLock(deadends: Array<String>, target: String): Int {
        var dead : HashSet<String> = HashSet()
        for(items in deadends){
            dead.add(items)
        }
        var visited : HashSet<String> = HashSet()
        visited.add("0000")
        var turnedSteps = 0
        var queue : LinkedList<String> = LinkedList()
        queue.add("0000")

        while(queue.isNotEmpty()){
            var size = queue.size
            for(items in 0 until size){
                var current = queue.poll()
                if(dead.contains(current))continue
                if(current == target)return turnedSteps
                for(numbers in 0..3){
                    var next = plus(current,numbers)
                    var previous = minus(current,numbers)
                    if(!visited.contains(next)){
                        queue.add(next)
                        visited.add(next)
                    }
                    if(!visited.contains(previous)){
                        queue.add(previous)
                        visited.add(previous)
                    }
                }
            }
            turnedSteps++
        }
        return -1
    }

}