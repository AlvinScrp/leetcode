package leetcode.tree;

public class P108_sortedArrayToBST {

    public static void main(String[] args) {
        new P108_sortedArrayToBST().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBST(nums, left, middle - 1);
        root.right = sortedArrayToBST(nums, middle + 1, right);
        return root;
    }


}
