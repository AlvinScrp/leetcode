import java.util.LinkedList;

class A402 {

    public static void main(String[] args) {
        System.out.println(new A402().new Solution().removeKdigits("1432219", 3));
        System.out.println(new A402().new Solution().removeKdigits("10200", 1));
        System.out.println(new A402().new Solution().removeKdigits("112", 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            int n = num.length();
            if (n <= k) return "0";
            LinkedList<Character> list = new LinkedList<>();
            int count = 0;
            for (int i = 0; i < n; ) {
                char c = num.charAt(i);
                if (list.isEmpty() || c >= list.peekLast() || count == k) {
                    list.add(c);
                    i++;
                } else {
                    list.removeLast();
                    count++;
                }
            }
            while (list.size() > n - k) list.removeLast();
            StringBuilder sb = new StringBuilder();
            while (!list.isEmpty()) {
                char c = list.pollFirst();
                if (c != '0' || sb.length() > 0) {
                    sb.append(c);
                }
            }
            return sb.length() == 0 ? "0" : sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







