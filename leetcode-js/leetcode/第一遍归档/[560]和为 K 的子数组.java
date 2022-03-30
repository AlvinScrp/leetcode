import java.util.HashMap;
import java.util.Map;

class A560 {

    public static void main(String[] args) {
        System.out.println(new A560().new Solution().subarraySum(new int[]{1, 2, 3}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {

            //key:前缀和 value：此和出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            int pre = 0, count = 0;
            map.put(pre, 1);
            for (int num : nums) {
                pre += num;
                if (map.containsKey(pre - k)) {
                    count += map.get(pre - k);
                }
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







