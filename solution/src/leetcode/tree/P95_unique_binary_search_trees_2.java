package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class P95_unique_binary_search_trees_2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(3).size());

    }

//    public static List<TreeNode> generateTrees(int n) {
//        if (n == 0) {
//            return new LinkedList<>();
//        }
//        List<TreeNode> nodes = generateTrees(1, n);
//        return nodes;
//    }
//
//    public static List<TreeNode> generateTrees(int start, int end) {
//        List<TreeNode> nodes = new LinkedList<>();
//        if (start > end) {
//            nodes.add(null);
//            return nodes;
//        }
//        for (int i = start; i <= end; i++) {
//
//            List<TreeNode> lefts = generateTrees(start, i - 1);
//            List<TreeNode> rights = generateTrees(i + 1, end);
//
//            for (TreeNode left : lefts) {
//                for (TreeNode right : rights) {
//                    TreeNode node = new TreeNode((i));
//                    node.left = left;
//                    node.right = right;
//                    nodes.add(node);
//                }
//            }
//        }
//        return nodes;
//
//    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(new TreeNode(1));
        for (int i = 2; i <= n; i++) {
            List<TreeNode> temps = new LinkedList<>();
            for (TreeNode node : nodes) {
                //i is root
                TreeNode current = new TreeNode(i);
                current.left = nodeCopy(node);
                temps.add(current);
                //i is right leaf
                TreeNode temp = nodeCopy(node);
                temp = appendRightLeaf(temp, i);
                temps.add(temp);
            }
            for (TreeNode node : nodes) {
                TreeNode root = node;
                TreeNode last = root;
                while (true) {
                    if (last.right == null) {
                        break;
                    }
                    TreeNode newNode = insert(nodeCopy(root), nodeCopy(last), new TreeNode(i));
                    temps.add(newNode);
                    last = last.right;
                }
            }
            nodes = temps;
        }
        return nodes;
    }

    private static TreeNode insert(TreeNode root, TreeNode last, TreeNode node) {
        TreeNode temp = root;
        while (true) {
            if (temp.val == last.val) {
                TreeNode oldRight = temp.right;
                temp.right = node;
                node.left = oldRight;
                break;
            }
            temp = temp.right;
        }
        return root;

    }

    public static TreeNode appendRightLeaf(TreeNode current, int val) {
        //先折叠，再填在到右叶子节点
        TreeNode temp = current;
        while (true) {
            if (temp.right == null) {
                temp.right = new TreeNode(val);
                break;
            }
            temp = temp.right;
        }
        return current;
    }

    public static TreeNode nodeCopy(TreeNode source) {
        if (source == null) {
            return null;
        }
        TreeNode node = new TreeNode(source.val);
        if (source.left != null) {
            node.left = nodeCopy(source.left);
        }
        if (source.right != null) {
            node.right = nodeCopy(source.right);
        }
        return node;


    }
}



