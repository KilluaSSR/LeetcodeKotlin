class Solutiont25 {
    fun reverseAB(a: ListNode?, b:ListNode?):ListNode?{
        var pre:ListNode? = null
        var current = a
        var nxt = a
        while(current!=b){
            nxt = current?.next
            current?.next = pre
            pre = current
            current = nxt
        }
        return pre

    }
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if(head == null) return null
        var current = head
        var end = head
        for(i in 1..k){
            if(end == null)return head
            end = end?.next
        }
        var newHead = reverseAB(head, end)
        current?.next = reverseKGroup(end, k)
        return newHead
    }
}
fun main() {
    // 创建链表 1->2->3->4->5
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    // k = 2
    val k = 2
    val solution = Solutiont25()
    var result = solution.reverseKGroup(node1, k)

    // 打印反转后的链表
    while (result != null) {
        print("${result.`val`}->")
        result = result.next
    }
    println("null")
}