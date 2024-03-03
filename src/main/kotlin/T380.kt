import java.util.ArrayList
import java.util.Random

class RandomizedSet() {
    val list = ArrayList<Int>()
    val hashmap = HashMap<Int,Int>()

    fun insert(`val`: Int): Boolean {
        if (hashmap.containsKey(`val`))return false
        hashmap[`val`] = list.size
        list.add(`val`)
        return true
    }

    fun remove(`val`: Int): Boolean {
        if(!hashmap.containsKey(`val`)) return false
        val elementToRemove = list.last()
        val indexToRemove = hashmap[`val`]!!
        list[indexToRemove] = elementToRemove
        list.removeAt(indexToRemove-1)
        hashmap.remove(`val`)
        return true

    }

    fun getRandom(): Int {
        val random = list.indices.random()
        return list[random]
    }

}
