import java.util.HashSet;
import java.util.Set;

class A804 {

    public static void main(String[] args) {
        System.out.println(new A804().new Solution().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] moses = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
            Set<String> ans = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.setLength(0);
                for (int i = 0; i < word.length(); i++) {
                    sb.append(moses[word.charAt(i) - 'a']);
                }
                ans.add(sb.toString());
            }
            return ans.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







