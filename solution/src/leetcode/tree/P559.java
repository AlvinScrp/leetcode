package leetcode.tree;

import java.util.List;

public class P559 {


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

    int max;
    public int maxDepth(Node root) {
        max = 0;
        dfs(root, 0);
        return max;

    }

    private void dfs(Node node, int count) {
        if (node == null) {
            max = Math.max(max, count);
            return;
        }

        if (node.children == null || node.children.isEmpty()) {
            max = Math.max(max, count + 1);
            return;
        }
        for (Node child : node.children) {
            dfs(child, count + 1);
        }
    }
}
