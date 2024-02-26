   class SolutionT86 {
       fun partition(head: ListNode?, x: Int): ListNode? {
        var dummy = ListNode(-1)
        var dummy2 = ListNode(-1)
        var p1 = dummy
        var p2 = dummy2
        var l = head
        while(l!=null ){
            if(l.`val`< x){
                p1.next = l
                p1 = p1.next!!
            }
            if(l.`val` >=x){
                p2.next = l
                p2 = p2.next!!
            }
            l = l.next

        }
        p2.next = null
        p1.next = dummy2.next
        
        return dummy.next
   
       }
   }
   fun main(args: Array<String>) {
    
   }