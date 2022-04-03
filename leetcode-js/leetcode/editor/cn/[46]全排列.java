import java.util.LinkedList;
import java.util.List;

class A46 {

    public static void main(String[] args) {
        // System.out.println(new A46().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> ans = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            dfs(nums, new boolean[nums.length], new LinkedList<>());
            return ans;
        }

        private void dfs(int[] nums, boolean[] used, LinkedList<Integer> path) {
            if (path.size() == nums.length) {
                ans.add(new LinkedList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, used, path);
                path.removeLast();
                used[i] = false;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







