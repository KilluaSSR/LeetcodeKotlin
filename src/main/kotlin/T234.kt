package old01

import ListNode

class SolutionT234{
    var left:ListNode? = null
    fun isPalindrome(head: ListNode?): Boolean {
        left = head
        return processed(head)
    }
    fun processed(head:ListNode?):Boolean{
        if(head==null)return true
        var res = processed(head?.next)
        var ans = res&&(left?.`val`==head?.`val`)
        left = left?.next
        return ans
    }

}
fun main() {
    // 创建链表 1->2->3->4->5
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(2)
    val node4 = ListNode(1)
    node1.next = node2
    node2.next = node3
    node3.next = node4

        var result = SolutionT234().isPalindrome(node1)
    println(result)
}