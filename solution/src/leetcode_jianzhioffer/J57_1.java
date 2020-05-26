package leetcode_jianzhioffer;

public class J57_1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int p = 0, q = nums.length - 1;
        while (p < q) {
            int sum = nums[p] + nums[q];
            if (sum == target) break;
            if (sum > target) q--;
            else p++;
        }
        return new int[]{nums[p], nums[q]};

    }


}
