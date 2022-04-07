class A796 {

    public static void main(String[] args) {
        // System.out.println(new A796().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) return false;
            if (s.equals(goal)) return true;
            for (int i = 1; i < s.length(); i++) {
                if ((s.substring(i) + s.substring(0, i)).equals(goal)) return true;
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







