//import java.util.LinkedList
//import java.util.PriorityQueue
//
//class T2617 {
//    fun minimumVisitedCells(grid: Array<IntArray>): Int {
//        val m = grid.size
//        val n = grid[0].size
//        var diatance = Array(n) { IntArray(n) { -1 } }
//        val row = Array(m) {
//            PriorityQueue<IntArray> { a, b ->
//                if (a[0] == b[0]) {
//                    a[1] - b[1]
//                } else {
//                    a[0] - b[0]
//                }
//            }
//        }
//        val col = Array(n) {
//            PriorityQueue<IntArray> { a, b ->
//                if (a[0] == b[0]) {
//                    a[1] - b[1]
//                } else {
//                    a[0] - b[0]
//                }
//            }
//        }
//        diatance[0][0]=1
//        for (i in 0 until m){
//            for (j in 0 until n){
//
//            }
//        }
//    }
//}
