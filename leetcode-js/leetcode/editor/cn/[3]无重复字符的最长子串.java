import java.util.HashMap;

class A3 {

    public static void main(String[] args) {
        // System.out.println(new A3().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() <= 1) return s.length();
            HashMap<Character, Integer> map = new HashMap<>();
            int ans = 0;
            for (int i = 0, j = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    for (int k = map.get(c); j <= k; j++) {
                        map.remove(s.charAt(j));
                    }
                }
                map.put(c, i);
                ans = Math.max(ans,map.size());
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







