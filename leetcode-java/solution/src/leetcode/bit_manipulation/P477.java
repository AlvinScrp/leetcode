package leetcode.bit_manipulation;

public class P477 {

    /**
     * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
     * 计算一个数组中，任意两个数之间汉明距离的总和。
     * <p>
     * 示例:
     * 输入: 4, 14, 2
     * 输出: 6
     * <p>
     * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
     * 所以答案为：
     * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
     * <p>
     * 数组中元素的范围为从 0到 10^9。
     * 数组的长度不超过 10^4。
     *
     * @return
     */

    public static void main(String[] args) {
        System.out.println(new P477().totalHammingDistance(new int[]{4, 14, 2}));
    }

    public int totalHammingDistance(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        if (max == 0) return 0;
        int mask = 1, sum = 0;
        while (max > 0) {
            int count0 = 0;
            for (int num : nums) {
                count0 += (num & mask) == 0 ? 1 : 0;
            }
            max >>= 1;
            mask <<= 1;
            sum += (count0 * (nums.length - count0));
        }
        return sum;

    }
}
