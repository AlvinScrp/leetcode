import java.util.LinkedList;
import java.util.Stack;

class A394 {

    public static void main(String[] args) {
        System.out.println(new A394().new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new A394().new Solution().decodeString("2[abc]3[cd]ef"));
        System.out.println(new A394().new Solution().decodeString("abc3[cd]xyz"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            LinkedList<Character> list = new LinkedList<>();
            Stack<Integer> countes = new Stack<>();
            int pre = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    pre = pre * 10 + (c - '0');
                } else {
                    if (c != ']') {
                        if (c == '[') {
                            countes.push(pre);
                            pre = 0;
                        }
                        list.addLast(c);
                    } else {
                        LinkedList<Character> temp = new LinkedList<>();
                        while (true) {
                            char ch = list.pollLast();
                            if (ch == '[') break;
                            temp.addFirst(ch);
                        }
                        int count = countes.pop();
                        for (int j = 0; j < count; j++) {
                            list.addAll(temp);
                        }

                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Character character : list) {
                sb.append(character);
            }
            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







