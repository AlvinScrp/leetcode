import java.util.HashSet;
import java.util.Set;

class A3 {

    public static void main(String[] args) {
        // System.out.println(new A3().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            if (n <= 1) return n;
            int max = 0;
            Set<Character> set = new HashSet<>();
            for (int i = 0, j = 0; i < n; i++) {
                char c = s.charAt(i);
                if (!set.contains(c)) {
                    set.add(c);
                    max = Math.max(max, set.size());
                } else {
                    while (j < i) {
                        if (s.charAt(j) != c) {
                            set.remove(s.charAt(j));
                            j++;
                        } else {
                            j++;
                            break;
                        }
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







