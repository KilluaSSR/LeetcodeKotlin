class Interview0101{
    fun isUnique(astr: String): Boolean {
        if (astr.length>26)return false
        var marker = 0
        for(char in astr){
            val offset = char-'a'
            if(marker and (1 shl offset) >0) return false
            marker = marker or (1 shl offset)
            println(marker.toString(2))
        }
        return true
    }
}

