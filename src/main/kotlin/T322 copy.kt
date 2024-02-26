class SolutionT322 {

    fun coinChange(coins: IntArray, amount: Int): Int {
        var memo = Array<Int>(amount+1){-666}

        return dp(coins,amount,memo)
    }
    fun dp(coins:IntArray,amount:Int,memo: Array<Int>):Int{
        if (amount==0)return 0
        if (amount<0) return -1
        if(memo[amount]!=-666)return  memo[amount]
        var res = Int.MAX_VALUE
        for(coin in coins){
            var cur = dp(coins,amount-coin,memo)
            if(cur==-1) continue
            res = Math.min(res,1+cur)
        }
        memo[amount] =  if(res == Int.MAX_VALUE) -1 else res
        return memo[amount]

    }
}