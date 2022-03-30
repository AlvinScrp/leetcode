import java.util.HashSet;
import java.util.Set;

class A128 {

    public static void main(String[] args) {
        // System.out.println(new A128().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) set.add(num);
            int max = 0;
            for (int num : nums) {
                if (set.contains(num - 1)) continue;
                int count = 1;
                while (set.contains(num + count)) count++;
                max = Math.max(max, count);
            }
            return max;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







