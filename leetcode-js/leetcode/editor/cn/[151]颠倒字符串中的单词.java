import java.util.LinkedList;

class A151 {

    public static void main(String[] args) {
        System.out.println(new A151().new Solution().reverseWords("the sky is blue"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            int n = s.length();
            LinkedList<String> ans = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == ' ') {
                    continue;
                }
                int j = i;
                for (; j < n && s.charAt(j) != ' '; j++) ;
                ans.addFirst(s.substring(i, j));
                i = j;
            }
            return String.join(" ", ans);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







