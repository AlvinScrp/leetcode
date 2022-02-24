package leetcode.p101_200;

public class P124_maxPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
//        TreeNode a5=new TreeNode(5);
//        TreeNode a4=new TreeNode(4);
//        TreeNode a8=new TreeNode(8);
//        TreeNode a11=new TreeNode(11);
//        TreeNode a13=new TreeNode(13);
//        TreeNode a4_=new TreeNode(4);
//        TreeNode a7=new TreeNode(7);
//        TreeNode a2=new TreeNode(2);
//        TreeNode a1=new TreeNode(1);
//
//        a5.left=a4;a5.right=a8;
//        a4.left=a11;
//        a8.left=a13;a8.right=a4_;
//        a11.left=a7;a11.right=a2;
//        a4_.right=a1;

//        TreeNode root=a5;

        TreeNode a9 = new TreeNode(9);
        TreeNode a3_ = new TreeNode(-3);
        a9.left = new TreeNode(6);
        a9.right = a3_;
        a3_.left = new TreeNode(-6);

        a3_.right = new TreeNode(2);
        a3_.right.left = new TreeNode(2);
        a3_.right.left.left = new TreeNode(-6);
        a3_.right.left.right = new TreeNode(-6);
        a3_.right.left.left.left = new TreeNode(-6);

        TreeNode root = a9;
//        TreeNode root= a3_;

        System.out.println(maxPathSum(root));
    }
//    [5,4,8,11,null,13,4,7,2,null,null,null,1]

    //    public static int maxPathSum(TreeNode root) {
//        if (root == null) {
//            return Integer.MIN_VALUE;
//        }
//
//        int left = maxPathSum(root.left);
//        int right = maxPathSum(root.right);
//        int maxCrossRoot = maxPathSumCrossRoot(root);
//        int max = Math.max(left, Math.max(right, maxCrossRoot));
//        return max;
//    }
//
//    public static int maxPathSumCrossRoot(TreeNode root) {
//        if (root.left == null && root.right == null) {
//            return root.val;
//        }
//        int maxLeft = dfs(root.left,  0, 0);
//        int maxRight = dfs(root.right,  0, 0);
//        return maxLeft + maxRight + root.val;
//    }
//
//    private static int dfs(TreeNode node, int currentSum, int maxSum) {
//        if (node == null) {
//            return Math.max(maxSum, currentSum);
//        }
//        currentSum = currentSum + node.val;
//        maxSum=Math.max(currentSum, maxSum);
//        maxSum = dfs(node.left, currentSum, maxSum);
//        maxSum = dfs(node.right, currentSum, maxSum);
//        return maxSum;
//
//    }
    static int max;
    public static int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if (root == null) {
            return max;
        }
        max_gain(root);
        return max;
    }

    public static int max_gain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(max_gain(node.left), 0);
        int right = Math.max(max_gain(node.right), 0);
        max = Math.max(max, left + right + node.val);
        return node.val + Math.max(left, right);
    }
}
