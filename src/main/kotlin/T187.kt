class SolutionT187 {
    fun findRepeatedDnaSequences(s: String): List<String> {
        val ans = mutableListOf<String>()
        val lib = HashMap<Char,Int>()
        lib['A'] = 0
        lib['C'] = 1
        lib['T'] = 2
        lib['G'] = 3
        val hashMap = HashMap<Int,Int>()
        var x = 0
        for (i in 0 until 9){
            x = (x shl 2) or (lib[s[i]]!!)
        }
        for(i in 0..  s.length-10){
            x = ((x shl 2) or (lib[s[i+9]]!!)) and ((1 shl 20) -1)
            hashMap[x] = hashMap.getOrDefault(x, 0) + 1
            if(hashMap[x]==2){
                ans.add(s.substring(i,i+10))
            }
        }
        return ans
    }





}