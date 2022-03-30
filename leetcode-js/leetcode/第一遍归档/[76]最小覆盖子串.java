import java.util.HashMap;
import java.util.Map;

class A76 {

    public static void main(String[] args) {
        System.out.println("--: " + new A76().new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("--: " + new A76().new Solution().minWindow("a", "a"));
        System.out.println("--: " + new A76().new Solution().minWindow("a", "aa"));
        System.out.println("--: " + new A76().new Solution().minWindow("aa", "aa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            //t需要的字符及其个数，负个数表示余量
            Map<Character, Integer> tMap = new HashMap<>();
            int need = t.length();
            int[] ans = null;

            for (char c : t.toCharArray()) {
                tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            }
            char[] chars = s.toCharArray();
            int i = 0, j = 0;
            for (; i < chars.length; i++) {
                char c = chars[i];
                if (!tMap.containsKey(c)) continue;

                tMap.put(c, tMap.get(c) - 1);
                if (tMap.get(c) >= 0) need--;

                if (need == 0) {
                    for (; i - j + 1 >= t.length(); j++) {
//                    for (; j < i; j++) {
                        char cj = chars[j];
                        if (tMap.containsKey(cj)) {
                            if (tMap.get(cj) == 0) break;
                            tMap.put(cj, tMap.get(cj) + 1);
                        }
                    }
                    if (ans == null || i - j + 1 <= ans[1] - ans[0]) {
                        ans = new int[]{j, i};
                    }
                }
            }
            if (ans == null) return "";
            return s.substring(ans[0], ans[1] + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







