class A215 {

    public static void main(String[] args) {
        System.out.println(new A215().new Solution()
                .findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            quick(nums, 0, nums.length - 1, nums.length - k);
            return nums[nums.length - k];
        }

        private void quick(int[] nums, int l, int r, int k) {
            if (l >= r) return;
            int pivot = nums[l];
            int i = l + 1, j = r;
            while (i < j) {
                while (i < j && nums[i] < pivot) i++;
                while (i < j && nums[j] >= pivot) j--;
                if (i != j) {
                    swap(nums, i, j);
                }
            }
            if (nums[j] >= pivot) j--;
            swap(nums, l, j);
            if (j > k) {
                quick(nums, l, j - 1, k);
            } else {
                quick(nums, j + 1, r, k);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







