package leetcode_jianzhioffer;

import java.util.*;

public class J61 {
    /**
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
     * <p>
     * A 不能视为 14。
     * <p>
     * 输入: [1,2,3,4,5]
     * 输出: True
     *  
     * 输入: [0,0,1,2,5]
     * 输出: True
     *
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new J61().isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new J61().isStraight(new int[]{0, 0, 1, 2, 5}));
        System.out.println(new J61().isStraight(new int[]{0, 0, 1, 2, 6}));

    }

//    public boolean isStraight(int[] nums) {
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        int zeroCount = 0;
//        for (int num : nums) {
//            if (num == 0) zeroCount++;
//            else queue.add(num);
//        }
//        if (queue.isEmpty()) return true;
//
//        int pre = queue.poll();
//        while (!queue.isEmpty()) {
//            int next = queue.peek();
//            if (next > pre && next - pre - 1 <= zeroCount) {
//                zeroCount -= (next - pre - 1);
//                pre = queue.poll();
//            } else {
//                break;
//            }
//        }

//        return queue.isEmpty();

//    }

    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return false;
            if (nums[i] != 0) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
                set.add(nums[i]);
            }
        }
        return max - min <= 4;

    }
}
