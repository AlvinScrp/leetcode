import java.util.HashMap;
import java.util.Map;

class A76 {

    public static void main(String[] args) {
        // System.out.println(new A76().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int n = t.length(), m = s.length();
            if (m < n) return "";
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            }
            int L = m + 1;
            int start = -1;
            int need = n;
            for (int i = 0, j = 0; i < m; i++) {
                char c = s.charAt(i);
                if (!map.containsKey(c)) continue;
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    need--;
                }
                //j~i为当前包含t的最小串
                if (need == 0) {
                    for (; i - j + 1 >= n; j++) {
                        char cj = s.charAt(j);
                        if (map.containsKey(cj)) {
                            if (map.get(cj) == 0) break;
                            map.put(cj, map.get(cj) + 1);
                        }
                    }
                    if (i - j + 1 < L) {
                        L = i - j + 1;
                        start = j;
                    }
                }
            }
            return start < 0 ? "" : s.substring(start, start + L);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







