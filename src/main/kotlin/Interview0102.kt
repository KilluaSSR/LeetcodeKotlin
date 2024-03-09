class Interview0102 {
    fun CheckPermutation(s1: String, s2: String): Boolean {
        if(s1.length != s2.length)return false
        val hashmap = HashMap<Char,Int>()
        for(chars in s1){
            hashmap[chars] = hashmap.getOrDefault(chars,0)+1
        }
        for (chars in s2){
            hashmap[chars] = hashmap.getOrDefault(chars,0)-1
        }
        for (k in hashmap.values){
            if (k!=0)return false
        }
        return true
    }
}