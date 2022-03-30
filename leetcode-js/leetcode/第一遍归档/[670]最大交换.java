class A670 {

    public static void main(String[] args) {
        System.out.println(new A670().new Solution().maximumSwap(2736));
        System.out.println(new A670().new Solution().maximumSwap(9973));
        System.out.println(new A670().new Solution().maximumSwap(98368));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            if (num < 10) return num;
            char[] digits = String.valueOf(num).toCharArray();
            int n = digits.length;
            for (int i = 0; i < n; i++) {
                int k = n - 1;
                for (int j = n - 2; j >= i; j--) {
                    if (digits[j] > digits[k]) {
                        k = j;
                    }
                }
                if (digits[k] != digits[i]) {
                    char temp = digits[i];
                    digits[i] = digits[k];
                    digits[k] = temp;
                    break;
                }
            }
            return Integer.parseInt(new String(digits));


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







