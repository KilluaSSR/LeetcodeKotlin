import java.util.Stack

class MyQueue() {
    val stack1 = Stack<Int>()
    val stack2 = Stack<Int>()

    fun push(x: Int) {
        stack2.add(x)
    }

    fun pop(): Int {
        if(stack1.isEmpty()){
            while(stack2.isNotEmpty()){
                stack1.push(stack2.pop())
            }
        }
        return stack1.pop()
    }

    fun peek(): Int {
        if(stack1.isEmpty()){
            while(stack2.isNotEmpty()){
                stack1.push(stack2.pop())
            }
        }
        return stack1.peek()

    }

    fun empty(): Boolean {
        return stack1.isEmpty()&&stack2.isEmpty()
    }

}
