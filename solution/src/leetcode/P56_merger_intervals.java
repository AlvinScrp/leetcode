package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class P56_merger_intervals {

    public static void main(String[] args) {
        int[][] res = merge(new int[][]{{1, 4}, {2, 3}});
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(","+i);
            }
            System.out.println();
        }

    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(num -> num[0]));

        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res[index][1]) {
                //合并
                res[index][1] =Math.max( res[index][1],intervals[i][1]) ;
            } else {
                res[index + 1] = intervals[i];
                index++;
            }
        }
        return Arrays.copyOfRange(res, 0, index + 1);

    }

    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     *         示例 1:
     *
     *         输入: [[1,3],[2,6],[8,10],[15,18]]
     *         输出: [[1,6],[8,10],[15,18]]
     *         解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *         示例 2:
     *
     *         输入: [[1,4],[4,5]]
     *         输出: [[1,5]]
     *         解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     *         来源：力扣（LeetCode）
     *         链接：https://leetcode-cn.com/problems/merge-intervals
     *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
}
