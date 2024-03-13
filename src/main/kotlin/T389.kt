
fun findTheDifference(s: String, t: String): Char {
        var mark = 0
        for(chars in s+t){
            mark = mark xor chars.code
        }
        return Char(mark)


}

fun main() {
    println(findTheDifference("abcd", "abcde"))
}