class A165 {

    public static void main(String[] args) {
        System.out.println(new A165().new Solution().compareVersion("1.01", "1.001"));
        System.out.println(new A165().new Solution().compareVersion("0.1", "1.1"));
//        System.out.println(Integer.parseInt("0001"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int compareVersion(String version1, String version2) {

            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            for (int i = 0, j = 0; i < v1.length || j < v2.length; i++, j++) {
                int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
                int num2 = j < v2.length ? Integer.parseInt(v2[j]) : 0;
                if (num1 > num2) return 1;
                if (num1 < num2) return -1;
            }
            return 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







