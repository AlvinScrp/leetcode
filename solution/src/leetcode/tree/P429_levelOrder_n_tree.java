package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P429_levelOrder_n_tree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Node> nodes = new LinkedList<>();
        nodes.add(root);
        bfs(nodes, 0, res);
        return res;

    }

    private void bfs(List<Node> nodes, int deep, List<List<Integer>> res) {
        if (nodes == null || nodes.isEmpty()) {
            return;
        }
        if (deep == res.size()) {
            res.add(new LinkedList<>());
        }
        List<Node> children = new LinkedList<>();
        List<Integer> r = res.get(deep);
        for (Node node : nodes) {
            r.add(node.val);
            if (node.children != null && !node.children.isEmpty()) {
                children.addAll(node.children);
            }
        }
        bfs(children, deep + 1, res);
    }
}
