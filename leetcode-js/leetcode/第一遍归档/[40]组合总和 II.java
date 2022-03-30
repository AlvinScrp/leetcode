import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class A40 {

    public static void main(String[] args) {
        // System.out.println(new A40().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(candidates, 0, target, new LinkedList<>());
            return ans;
        }

        private void dfs(int[] candidates, int start, int target, LinkedList<Integer> path) {
            if (target <= 0 || start == candidates.length) {
                if (target == 0) ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                path.add(candidates[i]);
                dfs(candidates, i + 1, target - candidates[i], path);
                path.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







