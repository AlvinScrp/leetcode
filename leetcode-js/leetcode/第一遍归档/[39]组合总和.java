import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class A39 {

    public static void main(String[] args) {
//        System.out.println(new A39().new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
//        System.out.println(new A39().new Solution().combinationSum(new int[]{2, 3, 5}, 8));
//        System.out.println(new A39().new Solution().combinationSum(new int[]{2}, 1));
        System.out.println(new A39().new Solution().combinationSum(new int[]{7, 6, 3, 2}, 7));
        System.out.println(new A39().new Solution().combinationSum(new int[]{5, 3, 2}, 8));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
//            Arrays.sort(candidates);
            combinationSum(candidates, target, 0, new LinkedList<>());
            return ans;

        }

        private void combinationSum(int[] candidates, int target, int start, LinkedList<Integer> path) {
            if (target < 0) return;
            if (target == 0) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                path.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i, path);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







