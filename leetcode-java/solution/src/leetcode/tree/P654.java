package leetcode.tree;

public class P654 {
    /**
     * 输入：[3,2,1,6,0,5]
     * 输出：返回下面这棵树的根节点：
     * <p>
     * 6
     * /   \
     * 3     5
     * \    /
     * 2  0
     * \
     * 1
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        int maxIndex = findMaxIndex(nums, lo, hi);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, lo, maxIndex - 1);
        root.right = construct(nums, maxIndex + 1, hi);
        return root;
    }

    private int findMaxIndex(int[] nums, int lo, int hi) {
        int maxIndex = lo;
        for (int i = hi; i > lo; i--) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
