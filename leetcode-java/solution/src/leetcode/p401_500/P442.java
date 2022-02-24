package leetcode.p401_500;

import java.util.ArrayList;
import java.util.List;

public class P442 {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                res.add(nums[i]);
            }
        }
        return res;

    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }


    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                res.add(num);
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        return res;
    }

}
