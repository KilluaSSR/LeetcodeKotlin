package old01

import java.util.PriorityQueue

class SolutionT215 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>()//最小堆
        val maxHeap = PriorityQueue<Int>(compareBy<Int?> {it}.reversed())//最大堆
        for(num in nums){
            heap.offer(num)
            if(heap.size>k){
                heap.poll()
            }
        }
        return heap.peek()

    }
}