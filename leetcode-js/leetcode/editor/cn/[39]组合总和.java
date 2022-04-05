import java.util.LinkedList;
import java.util.List;

class A39 {

    public static void main(String[] args) {
        // System.out.println(new A39().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new LinkedList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            dfs(candidates,0, target, new LinkedList<>());
            return ans;

        }

        private void dfs(int[] candidates,int start, int target, LinkedList<Integer> path) {
            if (target <= 0) {
                if (target == 0) {
                    ans.add(new LinkedList<>(path));
                }
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                int candidate =candidates[i];
                path.addLast(candidate);
                dfs(candidates, i,target - candidate, path);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







