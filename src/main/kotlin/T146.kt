class LRUCache(capacity: Int) {
    val cache = LinkedHashMap<Int,Int>()
    val capacity = capacity
    fun get(key: Int): Int {
        if(!cache.containsKey(key)){
            return -1
        }
        cache.used(key)
        return key
    }

    fun put(key: Int, value: Int) {
        if (cache.containsKey(key)){
            cache[key] = value
            cache.used(key)
            return
        }
        if(cache.size+1>capacity){
            val key = cache.keys.iterator().next()
            cache.remove(key)
        }
        cache[key] = value
    }
    fun LinkedHashMap<Int,Int>.used(key:Int){
        val v = cache.remove(key)
        if(v!=null){
            cache[key] = v
        }
    }


}