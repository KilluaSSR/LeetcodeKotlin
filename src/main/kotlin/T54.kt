class SolutionT54 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int>  {
        if(matrix.isEmpty())return listOf()
        if(matrix.size == 1 && matrix[0].size == 1)return listOf(matrix[0][0])
        var upperBound = 0
        var lowerBound = matrix.size-1
        var lefterBound = 0
        var righterBound = matrix[0].size-1
        var answer : MutableList<Int> = mutableListOf()
        while(answer.size<matrix.size*matrix[0].size){
            if(upperBound<=lowerBound){
                for(i in lefterBound..righterBound){
                    answer.add(matrix[upperBound][i])
                }
                upperBound++
            }

            if (upperBound<=lowerBound){
                for (i in upperBound..lowerBound){
                    answer.add(matrix[i][righterBound])
                }
                righterBound--
            }


            if (righterBound>=lefterBound){
                for (i in righterBound downTo lefterBound){
                    answer.add(matrix[lowerBound][i])
                }
                lowerBound--
            }
            if (lowerBound>=upperBound){
                for (i in lowerBound downTo upperBound){
                    answer.add((matrix[i][lefterBound]))
                }
                lefterBound++
            }
        }
        return answer
    }

}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12)
    )
    val result = SolutionT54().spiralOrder(matrix)
    println(result.joinToString(", "))
}