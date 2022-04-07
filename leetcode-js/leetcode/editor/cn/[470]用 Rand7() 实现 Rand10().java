class A470 {

    public static void main(String[] args) {
        // System.out.println(new A470().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */
    class Solution extends SolBase {
        public int rand10() {
            int a, b;
            while ((a = rand7()) > 6) ;
            while ((b = rand7()) > 5) ;
            return (a % 2 == 0) ? b : b + 5;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class SolBase {
        public int rand7() {
            return 1;
        }
    }
}







