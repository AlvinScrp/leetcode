package leetcode.bit_manipulation;

import java.util.Arrays;

public class P338 {

    /**
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2
     * 输出: [0,1,1]
     * 示例 2:
     * <p>
     * 输入: 5
     * 输出: [0,1,1,2,1,2]
     *
     * @return
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
    }
    public  static  int[] countBits(int num) {

        int[] counts = new int[num + 1];
        counts[0] = 0;
        for (int i = 1; i <= num; i++) {
            counts[i] = (i & 1) == 1 ? (1 + counts[i - 1]) : (1 + counts[i & i - 1]);
        }
        return counts;

    }
}
