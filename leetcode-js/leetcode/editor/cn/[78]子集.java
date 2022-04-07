import java.util.LinkedList;
import java.util.List;

class A78 {

    public static void main(String[] args) {
        // System.out.println(new A78().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(nums, 0, new LinkedList<>());
            return ans;

        }

        private void dfs(int[] nums, int start, LinkedList<Integer> path) {
            if (start == nums.length) {
                ans.add(new LinkedList<>(path));
                return;
            }
            path.add(nums[start]);
            dfs(nums, start + 1, path);
            path.removeLast();
            dfs(nums, start + 1, path);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







