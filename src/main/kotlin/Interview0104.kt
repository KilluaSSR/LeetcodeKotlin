class Interview0104 {
    fun canPermutePalindrome(s: String): Boolean {
        val hashmap = HashMap<Char,Int>()
        for(index in s.indices){
            hashmap[s[index]] = hashmap.getOrDefault(s[index],0)+1
        }
        val length = s.length
        if(length%2==0){
            for (i in hashmap.values){
                if (i%2!=0){
                    return false
                }
            }
        }else{
            var count = 0
            for (i in hashmap.values){
                if (i%2!=0){
                    count++
                    if (count>1)return false
                }
            }
        }
        return true
    }
}