import node.Node;

import java.util.LinkedList;
import java.util.List;

class A429 {

    public static void main(String[] args) {
        // System.out.println(new A429().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        List<List<Integer>> ans = new LinkedList<>();

        public List<List<Integer>> levelOrder(Node root) {
            dfs(root, 0);
            return ans;
        }

        private void dfs(Node node, int h) {
            if (node == null) return;
            if (ans.size() == h) ans.add(new LinkedList<>());
            ans.get(h).add(node.val);
            if (node.children == null) return;
            for (Node child : node.children) dfs(child, h + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







