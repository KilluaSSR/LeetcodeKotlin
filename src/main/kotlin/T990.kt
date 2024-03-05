class SolutionT990 {
    fun equationsPossible(equations: Array<String>): Boolean {
        val uf = UnionFind(26)
        for (str in equations){
            val a0 = str[0].code-97
            val a1 = str[3].code-97
            if(str[1]=='='){
                if(!uf.connected(a0,a1)){
                    uf.union(a0,a1)
                }
            }
        }
        for (str in equations){
            val a0 = str[0].code-97
            val a1 = str[3].code-97
            if(str[1]=='!'){
                if(uf.connected(a0,a1))return false
            }
        }
        return true

    }
}
