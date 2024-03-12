
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val ans :MutableList<List<Int>> = ArrayList()
        val every : MutableList<Int> = ArrayList()
        backtrackt216(ans,every,k,n,1)
        return ans
    }

    fun backtrackt216(ans: MutableList<List<Int>>, every: MutableList<Int>,  k: Int, n: Int,start:Int) {
        if(every.size==k&&every.sum()==n){
            ans.add(ArrayList(every))
        }
        for (i in start..9){
            every.add(i)
            backtrackt216(ans, every,k, n,i+1)
            every.removeLast()
        }
    }
