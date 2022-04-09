import java.util.Arrays;

class A179 {

    public static void main(String[] args) {
        System.out.println(new A179().new Solution().largestNumber(new int[]{10, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {

            String[] s = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                s[i] = "" + nums[i];
            }
            Arrays.sort(s, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
            StringBuilder sb = new StringBuilder();
            for (String s1 : s) {
                sb.append(s1);
            }

            String ans = sb.toString();
            int i = 0;
            for (; i < ans.length(); i++) {
                if (ans.charAt(i) != '0') break;
            }
            return i == ans.length() ? "0" : (i == 0 ? ans : ans.substring(i));

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







