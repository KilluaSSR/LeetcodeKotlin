fun getHint(secret: String, guess: String): String {
    var bulls = 0
    var cows = 0
    val sec = HashMap<Int, Int>()
    val gue = HashMap<Int, Int>()
    for (chars in secret.indices) {
        if (secret[chars] == guess[chars]) {
            bulls++
        } else {
            sec[secret[chars].code] = sec.getOrDefault(secret[chars].code, 0) + 1
            gue[guess[chars].code] = gue.getOrDefault(guess[chars].code, 0) + 1
        }
    }
    for (i in '0'..'9') {
        cows += sec.getOrDefault(i.code, 0).coerceAtMost(gue.getOrDefault(i.code, 0))
    }
    return "${bulls}A${cows}B"
}
fun main() {
    println(getHint("1123", "0111"))
}