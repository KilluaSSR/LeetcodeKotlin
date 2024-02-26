class ListNodeReverse(var value:Int){
    var next:ListNodeReverse? = null
}
//反转链表所有元素
class LNReverseAll{
    fun reverse(head:ListNodeReverse?):ListNodeReverse?{
        if(head == null || head.next == null)return head
        var last = reverse(head.next)
        head?.next?.next = head
        head?.next = null
        return last


    }
}
//反转链表前N个元素
class LNReverseFirstN{
    var count = 0
    var successor :ListNodeReverse? = null
    fun reverse(head: ListNodeReverse?, number: Int): ListNodeReverse? {
        if(head == null || head.next == null || count+1 >= number)return head
        count++
        val last = reverse(head.next,number)
        if(count+1 == number){
            successor = head?.next?.next
        }
        count--
        head?.next?.next = head
        head?.next=null
        if(count==0){
            head.next = successor
        }
        return last
    }



    fun reverseMN(head:ListNodeReverse?,m:Int,n:Int):ListNodeReverse?{
        if(m==1){
             return reverse(head, n)
        }
        head?.next = reverseMN(head?.next,m-1,n-1)
        return head
    }
}

class LNReverseFirstNDemo{
    var successor: ListNode? = null // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    fun reverseN(head: ListNode?, n: Int): ListNode? {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head!!.next
            return head
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        val last = reverseN(head!!.next, n - 1)

        head!!.next!!.next = head
        // 让反转之后的 head 节点和后面的节点连起来
        head!!.next = successor
        return last
    }

}

/*
fun main() {
    val demo = LNReverseFirstNDemo()

    // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)

    // Print the original linked list
    println("Original Linked List: ")
    printLinkedList(head)

    // Reverse the first 3 nodes
    val n = 3
    val newHead = demo.reverseN(head, n)

    // Print the modified linked list
    println("\nLinked List after reversing first $n nodes: ")
    printLinkedList(newHead)
}

fun printLinkedList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.`val`} ")
        current = current.next
    }
    println()
}


}*/




fun reverseIterate(a:ListNode?,b:ListNode?):ListNode?{
    var pre : ListNode? = null
    var current : ListNode? = a
    var nxt : ListNode? = a
    while(current!=b){
        nxt = current?.next
        current?.next = pre
        pre = current
        current = nxt
    }
    return pre
}

fun main() {
    // 构建链表 1 -> 2 -> 3 -> 4 -> 5
    val node1 = ListNodeReverse(1)
    val node2 = ListNodeReverse(2)
    val node3 = ListNodeReverse(3)
    val node4 = ListNodeReverse(4)
    val node5 = ListNodeReverse(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    // 调用反转函数


    // 打印链表来验证结果，预期输出: 1 -> 4 -> 3 -> 2 -> 5
    printList(LNReverseFirstN().reverseMN(node1, 3, 4))
}

fun printList(head: ListNodeReverse?) {
    var current = head
    while (current != null) {
        print(current.value.toString() + " ")
        current = current.next
    }
}



//fun main() {
//    // Example 1
//    val head1 = ListNodeReverse(1).apply {
//        next = ListNodeReverse(2).apply {
//            next = ListNodeReverse(3).apply {
//                next = ListNodeReverse(4)
//            }
//        }
//    }
//    println("Original List 1: " + printList(head1))
//    val reversedHead1 = LNReverseFirstN().reverse(head1, 2)
//    println("Reversed First 2 in List 1: " + printList(reversedHead1))
//
//    // Example 2
//    val head2 = ListNodeReverse(5).apply {
//        next = ListNodeReverse(6).apply {
//            next = ListNodeReverse(7).apply {
//                next = ListNodeReverse(8).apply {
//                    next = ListNodeReverse(9)
//                }
//            }
//        }
//    }
//    println("\nOriginal List 2: " + printList(head2))
//    val reversedHead2 = LNReverseFirstN().reverse(head2, 3)
//    println("Reversed First 3 in List 2: " + printList(reversedHead2))
//}
//
//fun printList(head: ListNodeReverse?): String {
//    var current = head
//    val result = StringBuilder()
//    while (current != null) {
//        result.append(current.value).append(" ")
//        current = current.next
//    }
//    return result.toString().trim()
//}

class SolutionT92 {
    var nxt :ListNode? = null

    fun reverseN(head: ListNode?, n: Int):ListNode?{
        if(n==1){
            nxt = head?.next
            return head
        }
        val last = reverseN(head?.next,n-1)
        head?.next?.next= head
        head?.next = nxt
        return last
    }

    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if(left == 1){
            reverseN(head,right)
        }
        head?.next = reverseBetween(head?.next,left-1,right-1)
        return head
    }
}


