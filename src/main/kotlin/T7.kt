class SolutionT7 {
    fun reverse(x: Int): Int {
        val positive = "2147483647"
        val negative = "2147483648"
        var flag = 1
        if(x<0){
            flag = -1
        }
        var reversed = Math.abs(x).toString().reversed()
        if(flag>0){
            if(reversed.length < positive.length){
                return reversed.toInt()
            }
            if(reversed.length == positive.length){
                for (num in reversed.indices){
                    if(reversed[num].toInt() < positive[num].toInt()){
                        return reversed.toInt()
                    }else if (reversed[num].toInt() == positive[num].toInt()){
                        continue
                    }else{
                        return 0
                    }
                }
            }
        }else{
                if(reversed.length < negative.length){
                    return reversed.toInt()*flag
                }
                if(reversed.length == negative.length){
                    for (num in reversed.indices){
                        if(reversed[num].toInt() < negative[num].toInt()){
                            return reversed.toInt()*flag
                        }else if (reversed[num].toInt() == negative[num].toInt()){
                            continue
                        }else{
                            return 0
                        }
                    }
                }
        }
        return 0
    }
}

fun main() {
    println(SolutionT7().reverse(-2147483412))
}