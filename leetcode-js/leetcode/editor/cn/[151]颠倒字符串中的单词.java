import java.util.LinkedList;

class A151 {

    public static void main(String[] args) {
        System.out.println(new A151().new Solution().reverseWords("the sky is blue"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {

            s = s.trim();
            LinkedList<String> list = new LinkedList<>();
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    if (word.length() > 0) {
                        list.addFirst(word.toString());
                    }
                    word.setLength(0);
                } else {
                    word.append(c);
                }
            }
            list.addFirst(word.toString());

            return String.join(" ", list);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







