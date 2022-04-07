class A169 {

    public static void main(String[] args) {
        System.out.println(new A169().new Solution().majorityElement(new int[]{1, 2, 3, 4, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int a = -1, count = 0;
            for (int num : nums) {
                if (count == 0) a = num;
                count += num == a ? 1 : -1;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







