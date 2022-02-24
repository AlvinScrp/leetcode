package leetcode.tree;

public class P337_house_robber3 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(1);

        System.out.println(new P337_house_robber3().rob(root));


    }

//
//    static int sum0 = 0;
//    static int sum1 = 0;
//    static int maxSum = 0;

//    public int rob(TreeNode root) {
//
//        if (root == null) return 0;
//        if (root.left == null && root.right == null) return root.val;
//
//        int sum1 = root.val, sum2 = 0;
//        if (root.left != null) {
//            sum1 += rob(root.left.left) + rob(root.left.right);
//            sum2 += rob(root.left);
//        }
//
//        if (root.right != null) {
//            sum1 += rob(root.right.left) + rob(root.right.right);
//            sum2 += rob(root.right);
//        }
//        return Math.max(sum1, sum2);
//
//    }

    public int rob(TreeNode root) {

        int[] res = robInner(root);
        return Math.max(res[0], res[1]);

    }

    private int[] robInner(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;

        int[] left = robInner(root.left);
        int[] right = robInner(root.right);

        int not_do = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int do_it = root.val + left[0] + right[0];
        res[0] = not_do;
        res[1] = do_it;

        return res;
    }


//    private void levelTraversal(List<TreeNode> nodes, List<Integer> res) {
//        if (nodes == null || nodes.isEmpty()) {
//            return;
//        }
//        int sum = 0;
//        List<TreeNode> children = new LinkedList<>();
//        for (TreeNode node : nodes) {
//            if (node.left != null) children.add(node.left);
//            if (node.right != null) children.add(node.right);
//            sum += node.val;
//        }
//        res.add(sum);
//        levelTraversal(children, res);
//    }
}
