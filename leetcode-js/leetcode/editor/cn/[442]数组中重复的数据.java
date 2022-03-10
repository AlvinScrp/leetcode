import java.util.ArrayList;
import java.util.List;

class A442 {

    public static void main(String[] args) {
        //new A442().new Solution()
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int num = Math.abs(nums[i]);
                if (nums[num - 1] < 0) ans.add(num);
                else nums[num - 1] *= -1;
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







