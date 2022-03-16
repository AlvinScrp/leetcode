import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class A78 {

    public static void main(String[] args) {
//        List<List<Integer>> ans = new A78().new Solution().subsets(new int[]{1, 2, 3});
        List<List<Integer>> ans = new A78().new Solution().subsets(new int[]{0});
        StringBuilder sb = new StringBuilder();
        for (List<Integer> an : ans) {
            sb.append("[");
            for (Integer integer : an) {
                sb.append(integer + ",");
            }
            sb.append("],");

        }
        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(nums, 0, new LinkedList<>());
            return ans;

        }

        private void dfs(int[] nums, int start, LinkedList<Integer> path) {
            if (start == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }
            path.addLast(nums[start]);
            dfs(nums, start + 1, path);
            path.removeLast();
            dfs(nums, start + 1, path);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







