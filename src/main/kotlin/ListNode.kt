


class LinkedNode(var value:Int){
    var next:LinkedNode?= null
}
fun main(args: Array<String>) {
    val head = LinkedNode(1)
    head.next = LinkedNode(7)
    head.next?.next = LinkedNode(3)
    var currentNode = head
    try {
        while(currentNode != null){
            // Code inside the while loop
            println(currentNode.value)
            currentNode = currentNode.next!!
        }
    } catch (_: NullPointerException) {
    }
}






