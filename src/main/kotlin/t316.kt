package old01

import java.lang.StringBuilder
import java.util.Stack
import javax.xml.stream.events.Characters

//class SolutionT316 {
//    fun removeDuplicateLetters(s: String): String {
//        var stack : Stack<Char> = Stack()
//        val sb = StringBuilder()
//        val mutable = ArrayList<Char>()
//        for (letters in s){
//            mutable.add(letters)
//        }
//        for(items in s.indices){
//            mutable.removeAt(0)
//            if(stack.contains(s[items])){
//                continue
//            }
//            while(stack.isNotEmpty() && stack.peek()<s[items] && mutable.contains(s[items])){
//                stack.pop()
//            }
//            stack.push(s[items])
//        }
//
//    }
//
//}
//fun main() {
//    println(SolutionT316().removeDuplicateLetters("cbbbca"))
//
//}

