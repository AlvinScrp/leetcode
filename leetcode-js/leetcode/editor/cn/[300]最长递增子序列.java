class A300 {

    public static void main(String[] args) {
        System.out.println(new A300().new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] f = new int[n]; //保存长度为i的子序列的末尾元素，
            //可知f数组元素单调增。 新元素a用于：更新f[]中第一个比a大的元素
            int index = -1;
            for (int num : nums) {
                if (index < 0 || f[index] < num) {
                    f[++index] = num;
                } else {
                    int l = 0, r = index;
                    while (l < r) {
                        int mid = l + (r - l) / 2;
                        if (f[mid] < num) {
                            l = mid + 1;
                        } else {
                            r = mid;
                        }
                    }
                    f[l] = num;
                }
            }
            return index + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







