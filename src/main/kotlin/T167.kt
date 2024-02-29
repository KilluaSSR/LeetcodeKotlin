package old01

class SolutionT167 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size-1
        while(left<right){
            if(numbers[left]+numbers[right] == target)return intArrayOf(left+1,right+1)
            if(numbers[left]+numbers[right] > target){right--}
            if(numbers[left]+numbers[right] < target){left++}
        }
        return intArrayOf(-1,-1)

    }
}