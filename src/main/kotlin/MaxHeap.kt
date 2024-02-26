class MaxHeap{
    private fun swap(heap: IntArray, i:Int, j:Int){
    val temp = heap[i]
    heap[i] = heap[j]
    heap[j] = temp
}

    fun buildHeap(heap:IntArray){
        val lastParentIndex = (heap.size-2)/2
        for (i in lastParentIndex downTo 0 ) {
            heaplify(heap, i, heap.size)
        }
    }

    fun heaplify(heap:IntArray,i:Int,n:Int){
        var left = 2*i+1
        var right = 2*i+2
        var largest = i
        if (left<n && heap[left]>heap[largest]) {
            largest = left
        }
        if( right<n && heap[right]>heap[largest]){
            largest = right
        }
        if(largest != i){
            swap(heap,largest,i)
            heaplify(heap, largest, n)
        }
    }
}
fun main(args: Array<String>) {
    MaxHeap().buildHeap(intArrayOf(3,4,5,6,7))
}


class MinHeap{
    private fun swap(heap: IntArray, i:Int, j:Int){
    val temp = heap[i]
    heap[i] = heap[j]
    heap[j] = temp
}

    fun buildHeap(heap:IntArray){
        val lastParentIndex = (heap.size-2)/2
        for(parent in lastParentIndex downTo 0){
            heaplify(heap, parent, heap.size)
        }
        
    }

    fun heaplify(heap:IntArray,i:Int,n:Int){
        var left = 2*i+1
        var right = 2*i+2
        var min = i
        if(heap[left]<heap[min] && left<n){
            min = left
        }
        if(heap[right]<heap[min] && right<n){
            min = right
        }
        if(min != i){
            swap(heap, min, i)
            heaplify(heap, min, n)
        }
    }
}