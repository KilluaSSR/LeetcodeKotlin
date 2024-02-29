package old01

class SolutionT876 {
    fun middleNode(head: ListNode?): ListNode? {
        var p1 : ListNode? = head
        var p2 : ListNode? = head
        while(p1?.next!=null){
            p1 = p1?.next?.next
            p2 = p2?.next
        }
        return p2

    }
}