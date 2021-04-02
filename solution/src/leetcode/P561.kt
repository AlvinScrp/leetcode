package leetcode

import java.util.*

class P561 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(P561().arrayPairSum(intArrayOf(1, 4, 3, 2)))
        }
    }

    fun arrayPairSum(nums: IntArray): Int {
        Arrays.sort(nums)
//        print(Arrays.toString(nums))
        return nums.filterIndexed { index, _ -> index % 2 == 0 }.fold(0, { acc, value -> acc + value })
    }
}