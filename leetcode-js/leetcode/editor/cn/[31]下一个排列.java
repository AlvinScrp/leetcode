import java.util.Arrays;
import java.util.Comparator;

class A31 {

    public static void main(String[] args) {
        // System.out.println(new A31().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {

            int n = nums.length;
            int i = n - 2;
            for (; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) break;
            }
            if (i < 0) {
                Arrays.sort(nums);
                return;
            }
            for (int j = n - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    break;
                }
            }
            Arrays.sort(nums, i + 1, nums.length);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







