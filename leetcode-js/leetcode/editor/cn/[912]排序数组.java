class A912 {

    public static void main(String[] args) {
        // System.out.println(new A912().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            sort(nums, 0, nums.length - 1);
            return nums;

        }

        private void sort(int[] nums, int l, int r) {
            if (l >= r) return;
            int pivot = nums[l], i = l + 1, j = l;
            //nums(l+1 ~ j) <p , nums(j+1 ~ i) >=p
            for (; i <= r; i++) {
                if (nums[i] < pivot) {
                    j++;
                    swap(nums, i, j);
                }
            }
            swap(nums, l, j);
            sort(nums, l, j - 1);
            sort(nums, j + 1, r);
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







