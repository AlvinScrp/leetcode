package leetcode;

public class P235_lowestCommonAncestor {

    public static void main(String[] args) {
//        new P110_isBalanced().isBalanced();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.val == q.val) {
            return p;
        }
        if (p.val < root.val&&q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val > root.val&&q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;


    }


}
