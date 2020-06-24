package leetcode.p101_200;

public class P101_isSymmetric {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return  isSymmetric(root.left,root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val
                && isSymmetric(left.left,right.right )
                && isSymmetric(left.right, right.left);

    }
}
