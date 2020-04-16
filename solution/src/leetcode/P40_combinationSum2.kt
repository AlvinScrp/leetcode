package leetcode

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    combinationSum2(intArrayOf(1, 1, 2), 3)?.forEach { println(it) }
    combinationSum2(intArrayOf( 2,5,2,1,2), 5)?.forEach { println(it) }


}

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    var res: ArrayList<List<Int>> = arrayListOf()
    dfs(candidates, target, 0, arrayListOf<Int>(), res)
    return res

}

fun dfs(candidates: IntArray, target: Int, start: Int, path: ArrayList<Int>, res: ArrayList<List<Int>>) {
    if (target == 0) {
        arrayListOf<Int>()
                .apply { this.addAll(path) }
                .takeUnless { res.contains(it) }
                ?.let { res.add(it) }
        return
    }
    for (i in start until candidates.size) {
        if (candidates[i] > target) {
            return
        }
        if(i>start&&candidates[i]==candidates[i-1]){
            continue
        }
        path.add(candidates[i])
        dfs(candidates, target - candidates[i], i+1, path, res)
        path.removeAt(path.size - 1)
    }
}
/**

给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
[1, 7],
[1, 2, 5],
[2, 6],
[1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/