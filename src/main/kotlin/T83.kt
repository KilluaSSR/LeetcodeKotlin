class SolutionT83 {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if(head == null || head.next == null) return head
        var slow = head
        var fast = head
        while(fast!=null){
            if(fast?.`val` != slow?.`val`){
                slow?.next = fast
                slow = slow?.next
            }
            fast = fast?.next
        }
        slow?.next = null
        return head
    }
}