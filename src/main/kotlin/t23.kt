import java.util.*

class SolutionT23 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty() || lists.all { it == null } )return null
        val pq = PriorityQueue<ListNode?>(lists.size,compareBy{it.`val`})
        val dummy = ListNode(-1)
        var p = dummy
        for(heads in lists){
            pq.add(heads)
        }
        while(pq.isNotEmpty()){
            val node = pq.poll()
            p.next = node
            if(node?.next!=null){
                pq.add(node.next)
            }
            p = p.next!!
        }
        return dummy.next

    }
}

fun main() {
    SolutionT23().mergeKLists(arrayOf(ListNode(1),ListNode(2),ListNode(3)))
}