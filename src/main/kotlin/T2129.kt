import java.util.*

fun capitalizeTitle(title: String): String {
    val dic = title.lowercase(Locale.getDefault()).split(' ')
    val capitalized = dic.map { words ->
        when (words.length > 2) {
            true -> words.replaceFirstChar { it.uppercase(Locale.getDefault()) }
            false -> words
        }
    }
    return capitalized.joinToString(" ")
}
fun main() {
    println(capitalizeTitle("i lOVE leEtcoDE"))
}
