package leetcode.tree;

public class P865 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(new P865().subtreeWithAllDeepest(root).val);
    }


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Result result = dfs(root, -1);
        return result.node;
    }


    private Result dfs(TreeNode node, int deep) {
        if (node == null) return new Result(null, deep);
        deep = deep + 1;
        Result left = dfs(node.left, deep);
        Result right = dfs(node.right, deep);
        int L = left.deep, R = right.deep;
        if (L > R) return left;
        if (R > L) return right;
        return new Result(node, Math.max(L, R));
    }

    class Result {
        TreeNode node;
        int deep;

        public Result(TreeNode node, int deep) {
            this.node = node;
            this.deep = deep;
        }
    }

}
