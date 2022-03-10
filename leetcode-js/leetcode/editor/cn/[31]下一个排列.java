import java.util.Arrays;

class A31 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 8, 5, 7, 6, 4};
        new A31().new Solution().nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            if (n <= 1) return;
            int i = n - 2;
            for (; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) break;
            }
            if (i < 0) {
                sort(nums, 0, n - 1);
            } else {
                for (int j = n - 1; j >= i + 1; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        sort(nums, i + 1, n - 1);
                        break;
                    }
                }
            }

        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void sort(int[] nums, int start, int end) {
            for (int j = end; j > start; j--) {
                for (int i = start; i < j; i++) {
                    if (nums[i] > nums[i + 1]) swap(nums, i, i + 1);
//                    if (nums[i] > nums[j]) {
//                        swap(nums, i, j);
//                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







