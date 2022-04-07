import java.util.LinkedList;

class A394 {

    public static void main(String[] args) {
        System.out.println(new A394().new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new A394().new Solution().decodeString("3[a2[c]]"));
        System.out.println(new A394().new Solution().decodeString("2[abc]3[cd]ef"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {

            LinkedList<Integer> counts = new LinkedList<>();
            LinkedList<String> sbs = new LinkedList<>();
            int pre = 0;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    counts.addLast(pre);
                    sbs.addLast(res.toString());
                    res = new StringBuilder();
                    pre = 0;
                } else if (c == ']') {
                    //"3[a2[c]]"
                    StringBuilder temp = new StringBuilder();
                    int count = counts.pollLast();
                    for (int k = 0; k < count; k++) temp.append(res);
                    res = new StringBuilder(sbs.pollLast() + temp);
                } else if (Character.isDigit(c)) {
                    pre = pre * 10 + (c - '0');
                } else {
                    res.append(c);
                }
            }

            return res.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







