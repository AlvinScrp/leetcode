package leetcode.p201_300;

import java.util.Arrays;

public class P287 {
    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        int num = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                num = nums[i];
                break;
            }
        }
        return num;

    }

//    给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
//
//    假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。


//    输入：nums = [1,3,4,2,2]
//    输出：2
//
//    输入：nums = [3,1,3,4,2]
//    输出：3
//
//    输入：nums = [1,1]
//    输出：1
//
//    输入：nums = [1,1,2]
//    输出：1


}
