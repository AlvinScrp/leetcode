class A283 {

    public static void main(String[] args) {
        // System.out.println(new A283().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            for (int j = 0, i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    if (i != j) {
                        nums[j] = nums[i];
                        nums[i] = 0;
                    }
                    j++;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







