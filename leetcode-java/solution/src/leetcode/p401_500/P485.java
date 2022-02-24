package leetcode.p401_500;

/**
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *

 * @return
 */
public class P485 {

    public static void main(String[] args) {
        System.out.println(new P485().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }


    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
