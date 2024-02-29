package old01

import kotlin.math.abs

class SolutionT475 {
        fun findRadius(houses: IntArray, heaters: IntArray): Int {
            houses.sort()
            heaters.sort()
            var ans = 0
            for(house in houses){
                var left = 0
                var right = heaters.size-1
                var nearest = Int.MAX_VALUE
                while(left<=right){
                    var mid = left + (right-left)/2
                    if(heaters[mid]>house){right = mid-1}
                    else if(heaters[mid]<house){left = mid+1}
                    else{
                        left = mid
                        break
                    }
                }
                if(left>=heaters.size){
                    nearest = house - heaters[heaters.size-1]
                }else if(right<0){
                    nearest = heaters[0] - house
                }else{if(left-1<0){
                    nearest = Math.abs(heaters[left]-house)
                }else{
                    nearest =Math.min( Math.abs(heaters[left] - house),Math.abs(heaters[left-1]-house))
                }
                }
                ans = Math.max(ans,nearest)
            }
            return ans
        }
}