package old01

class SolutionT141 {
    fun hasCycle(head: ListNode?): Boolean {
        var p1 = head
        var p2 = head
        while(p1?.next != null && p2?.next != null){
            p1 = p1?.next?.next
            p2 = p2?.next
            if(p1==p2)return true

        }
        return false
        
    }
}

