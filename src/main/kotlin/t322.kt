package old01

class SolutionT322 {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount==0)return 0
        var list = Array(amount+1){-666}
        return dp(coins, amount, list)
    }
    fun dp(coins: IntArray, amount: Int, list: Array<Int>):Int{
        if (amount ==0)return 0
        if(amount <0)return -1
        if (list[amount]!=-666)return  list[amount]
        var res = Int.MAX_VALUE
        for (coin in coins){
            var sub = dp(coins,amount-coin,list)
            if (sub == -1) continue
            res = Math.min(res,1+sub)
        }
        list[amount] = if (res==Int.MAX_VALUE)-1 else res
        return list[amount]
    }
}


fun main() {
   print( SolutionT322().coinChange(intArrayOf(1,2,5),11))
}