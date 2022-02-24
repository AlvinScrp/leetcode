package leetcode.p301_400;

public class P303_range_sum_query_immutable {

    public static void main(String[] args) {
//        int[] nums = {-2, 0, 3, -5, 2, -1};

        int[] nums = {};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}

class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n];
        if (n >= 1) {
            sums[0] = nums[0];
            if (n >= 2) {
                for (int i = 1; i < nums.length; i++) {
                    sums[i] = sums[i - 1] + nums[i];
                }
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        }
        return sums[j] - sums[i - 1];

    }
}

/**
 * Your leetcode.p301_400.NumArray object will be instantiated and called as such:
 * leetcode.p301_400.NumArray obj = new leetcode.p301_400.NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
