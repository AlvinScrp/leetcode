package leetcode.tree;

public class P236_lowestCommonAncestor {

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
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode node = new P236_lowestCommonAncestor().lowestCommonAncestor(root, root.left.right.left, root.right.right);
        System.out.println(node.val);


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) return null;
//
//        LinkedList<TreeNode> pathP = findNodeList(root, p);
//        LinkedList<TreeNode> pathQ = findNodeList(root, q);
//
//        TreeNode ancestor = null;
//        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
//            if (pathP.get(i) == pathQ.get(i)) {
//                ancestor = pathP.get(i);
//            }
//        }
//        return ancestor;
//
//    }
//
//    private LinkedList<TreeNode> findNodeList(TreeNode current, TreeNode node) {
//        LinkedList<TreeNode> path = new LinkedList<>();
//        findNode(current, node, path);
//        for (TreeNode treeNode : path) {
//            System.out.print("," + treeNode.val);
//        }
//        System.out.println();
//        return path;
//
//    }
//
//    private boolean findNode(TreeNode current, TreeNode node, LinkedList<TreeNode> path) {
//        if (current == null) return false;
//
//        path.add(current);
//        if (current == node) return true;
//
//        if (current.left == null && current.right == null) {
//            return false;
//        }
//
//        if(current.left!=null) {
//            if (findNode(current.left, node, path)) return true;
//            path.removeLast();
//        }
//        if(current.right!=null) {
//            if (findNode(current.right, node, path)) return true;
//            path.removeLast();
//        }
//        return false;
//    }
}
