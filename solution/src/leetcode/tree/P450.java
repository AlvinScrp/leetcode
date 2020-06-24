package leetcode.tree;

public class P450 {

    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        deleteNode2(dummy, root, key, true);
        return dummy.left;

    }

    private void deleteNode2(TreeNode parent, TreeNode node, int key, boolean left) {
        if (node == null) return;
        if (node.val == key) {
            if (left) {
                parent.left = mergeLeftRight(node);
            } else {
                parent.right = mergeLeftRight(node);
            }
            return;
        }
        deleteNode2(node, node.val > key ? node.left : node.right, key, node.val > key);
    }

    private TreeNode mergeLeftRight(TreeNode node) {
        if (node.right == null) {
            return node.left;
        } else if (node.left == null) {
            return node.right;
        } else {
            TreeNode temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            temp.left = node.left;

            return node.right;
        }
    }

}
