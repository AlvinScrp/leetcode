class A14 {

    public static void main(String[] args) {
        // System.out.println(new A14().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            if (strs.length == 1) return strs[0];
            int i = 0;
            for (; i < strs[0].length(); i++) {
                for (int j = 1; j < strs.length; j++) {
                    String str = strs[j];
                    if (i == str.length() || str.charAt(i) != strs[0].charAt(i)) {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0].substring(0, i);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







