class A169 {

    public static void main(String[] args) {
        // System.out.println(new A169().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int value = 0, count = 0;
            for (int num : nums) {
                if (count == 0) value = num;
                count += (num == value ? 1 : -1);
            }
            return value;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







