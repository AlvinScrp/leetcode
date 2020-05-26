package leetcode_jianzhioffer;

import java.util.Arrays;

public class J56_2 {
    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     * 输入：nums = [3,4,3,3] 输出：4
     * 输入：nums = [9,1,7,9,7,9,7] 输出：1
     *
     * 本题和主站 260 是一样的. 除了这个，主站还有 136 和 137，645。 总共加起来本系列一共 四道题。
     *
     * @return
     */

    public static void main(String[] args) {
        System.out.println(new J56_2().singleNumber(new int[]{3, 4, 3, 3}));
        System.out.println(new J56_2().singleNumber(new int[]{9, 1, 7, 9, 7, 9, 7}));

    }

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;

        int tempA, tempB;
        for (int num : nums) {
            tempA = a;
            tempB = b;
            b = (num & ~tempA & ~tempB) | (~num & tempB);
//            b = (num ^ tempB) & ~tempA;
            a = (~num & tempA) | (num & tempB);
        }
        return b;
    }

//    public int singleNumber(int[] nums) {
//        int ans = 0, mask = 1, count;
//        for (int i = 0; i < 32; i++) {
//            count = 0;
//            for (int num : nums) {
//                if ((num & mask) != 0) count++;
//            }
//            if (count % 3 == 1) ans |= mask;
//            mask = mask << 1;
//        }
//        return ans;
//    }
}
