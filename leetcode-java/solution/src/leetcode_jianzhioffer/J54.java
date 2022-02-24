package leetcode_jianzhioffer;

public class J54 {
    int value;

    public int kthLargest(TreeNode root, int k) {
        value = -1;
        dfs(root, k);
        return value;

    }

    private int dfs(TreeNode node, int k) {
        if (node == null) return k;
        k = dfs(node.right, k);
        if (k == 1) {
            value = node.val;
            return 0;
        }
        return dfs(node.left, k - 1);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


