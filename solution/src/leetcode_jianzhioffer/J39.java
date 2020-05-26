package leetcode_jianzhioffer;

public class J39 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int ans = 0, count = 0;
        for (int num : nums) {
            if (count == 0) ans = num;
            count += (num == ans ? 1 : -1);
        }
        return ans;

    }
}
