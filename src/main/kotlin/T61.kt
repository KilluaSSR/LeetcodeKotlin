class SolutionT61 {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if(head==null)return null
        if(k==0)return head
        var nodeArray = mutableListOf<ListNode?>()
        var hd = head
        var end :ListNode? = null
        var size = 0
        while (hd!=null){
            nodeArray.add(hd)
            if(hd.next?.next==null) {
                end = hd.next
            }
            hd = hd.next
            size++
        }
        if(k%size==0)return head
        nodeArray[size - k%size -1]?.next =null
        end?.next = head
        return nodeArray[size - k%size]
    }
}