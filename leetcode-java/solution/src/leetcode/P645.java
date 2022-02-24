package leetcode;

import java.util.Arrays;

public class P645 {
    /**
     * 集合 S 包含从1到 n 的整数。
     * 不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
     * <p>
     * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
     * <p>
     * <p>
     * 输入: nums = [1,2,2,4]
     * 输出: [2,3]
     *
     * @return
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P645().findErrorNums(new int[]{1, 2, 2, 4})));
    }

    public int[] findErrorNums(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;
        for (int i = 1; i <= nums.length; i++) xor ^= i;
        int flag = xor & (-xor);

        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & flag) > 0) a ^= num;
            else b ^= num;
        }
        for (int i = 1; i <= nums.length; i++) {
            if ((i & flag) > 0) a ^= i;
            else b ^= i;
        }
        for (int num : nums) {
            if (num == a) {
                return new int[]{a, b};
            }
        }
        return new int[]{b, a};
    }
}
