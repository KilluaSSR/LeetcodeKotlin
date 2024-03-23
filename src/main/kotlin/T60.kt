class SolutionT60 {
    fun getPermutation(n: Int, k: Int): String {
        if (n == 1) return "1"
        var di = k
        val sb = StringBuilder()
        val nums = IntArray(n+1) {1}
        val avail = MutableList(n) { it + 1 }
        for (i in 2..n) nums[i] = nums[i - 1] * i // 预计算阶乘
        di-- // 将k转换为基于0的索引

        for (i in n downTo 1) {
            val index = di / nums[i - 1]
            sb.append(avail[index])
            avail.removeAt(index)
            di %= nums[i - 1]
        }
        return sb.toString()
    }
}

fun main() {
    println(SolutionT60().getPermutation(8, 6))
}