package leetcode.p201_300;

import java.util.ArrayList;
import java.util.List;

public class P229 {

    public static void main(String[] args) {
        System.out.println(new P229().majorityElement(new int[]{1, 2, 2, 3, 2, 1, 1, 3}));
        System.out.println(new P229().majorityElement(new int[]{0,0,0}));
    }

//        给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
//
//        说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
//
//        示例 1:
//
//        输入: [3,2,3]
//        输出: [3]
//        示例 2:
//
//        输入: [1,1,1,3,3,2,2,2]
//        输出: [1,2]

//    [1,2,2,3,2,1,1,3]

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        int ansA = nums[0],countA = 0, ansB=nums[0], countB = 0;
        for (int num : nums) {
            if (ansA == num) {
                countA++;
            } else if (ansB == num) {
                countB++;
            } else if (countA == 0) {
                ansA = num;
                countA++;
            } else if (countB == 0) {
                ansB = num;
                countB++;
            } else {
                countA--;
                countB--;
            }
        }
//        System.out.println(String.format("%d,%d   %d,%d", ansA, countA, ansB, countB));
        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == ansA) countA++;
            else if (num == ansB) countB++;
        }
        if (countA * 3 > nums.length) res.add(ansA);
        if (countB * 3 > nums.length) res.add(ansB);

        return res;
    }
}
