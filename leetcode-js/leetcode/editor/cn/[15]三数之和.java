import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class A15 {

    public static void main(String[] args) {
        // System.out.println(new A15().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new LinkedList<>();
            if (nums.length <= 2) return new ArrayList<>(ans);
            Arrays.sort(nums);
            for (int k = 0; k < nums.length - 2; k++) {
                if (nums[k] > 0) break;
                if (k > 0 && nums[k] == nums[k - 1]) continue;
                int l = k + 1, r = nums.length - 1;
                while (l < r) {
                    int value = nums[k] + nums[l] + nums[r];
                    if (value == 0) {
                        ans.add(Arrays.asList(nums[k], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[++l]) ;
                        while (l < r && nums[r] == nums[--r]) ;
                    } else if (value < 0) {
                        while (l < r && nums[l] == nums[++l]) ;
                    } else {
                        while (l < r && nums[r] == nums[--r]) ;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







