class ListNode(var `val`: Int) {
         var next: ListNode? = null
}
class SolutionT21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var dummy = ListNode(-1)
        var p =dummy
        var p1 = list1
        var p2 = list2
        while(p1!=null && p2!=null){
            if(p1.`val` > p2.`val`){
                p.next = p2
                p2 = p2.next
            }else{
                p.next = p1
                p1 = p1.next
            }
            p = p.next!!
        }
        if(p1 != null){
            p.next = p1
        }
        if(p2 != null){
            p.next = p2
        }
        return dummy.next
    }

}