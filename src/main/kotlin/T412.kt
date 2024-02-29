package old01

class SolutionT412 {
    fun fizzBuzz(n: Int): List<String> {
        var answer = (1..n).map { it.toString() }.toMutableList()
        for(i in 0..n-1){
            if((i+1)%3==0 && (i+1)%15!=0){
                answer[i] = "Fizz"
            }
            if((i+1)%5==0 && (i+1)%15!=0){
                answer[i] = "Buzz"
            }
            if ((i+1)%15==0){
                answer[i]="FizzBuzz"
            }
        }
        return answer

    }
}