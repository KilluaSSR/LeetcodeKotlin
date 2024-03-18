class SolutionT2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var dummy:ListNode =ListNode(-1)
        var pointer = dummy
        var la = l1
        var lb = l2
        var x = 0
        while (la!=null || lb!=null){
            val a = if(la==null) 0 else la.`val`
            val b = if(lb==null) 0 else lb.`val`
            if(a+b+x<10){
                pointer.next = ListNode(a+b+x)
                x=0
                la = la?.next
                lb = lb?.next
                pointer = pointer.next!!
            }else{
                pointer.next = ListNode(a+b+x-10)
                x = 1
                la = la?.next
                lb = lb?.next
                pointer = pointer.next!!
            }
        }
        if(x==1){
            pointer.next = ListNode(x)
        }
        return dummy.next
    }

}