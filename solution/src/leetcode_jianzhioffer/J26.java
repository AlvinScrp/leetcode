package leetcode_jianzhioffer;

public class J26 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * <p>
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return isSameTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null) return true;
        if (p == null) return false;

        return p.val == q.val
                && (q.left == null || isSameTree(p.left, q.left))
                && (q.right == null || isSameTree(p.right, q.right));

    }
}
