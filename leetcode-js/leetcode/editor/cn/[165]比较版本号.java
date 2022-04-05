class A165 {

    public static void main(String[] args) {
        // System.out.println(new A165().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] p = version1.split("\\.");
            String[] q = version2.split("\\.");
            for (int k = 0, a, b; k < p.length || k < q.length; k++) {
                a = k < p.length ? Integer.parseInt(p[k]) : 0;
                b = k < q.length ? Integer.parseInt(q[k]) : 0;
                if (a != b) {
                    return a < b ? -1 : 1;
                }
            }
            return 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







