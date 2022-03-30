import node.TreeNode;

class A297 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3, new TreeNode(4), new TreeNode(5));
        TreeNode node1 = new TreeNode(1, new TreeNode(2), node3);

        System.out.println(new A297().new Codec().serialize(node1));
//        System.out.println(new A297().new Codec().deserialize("1,2,null,null,3,4,null,null,5,null,null"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            s(root, sb);
            return sb.substring(1);
        }

        private void s(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(",null");
                return;
            }
            sb.append("," + node.val);
            s(node.left, sb);
            s(node.right, sb);
        }


        int index = 0;

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.trim().equals("")) return null;
            String[] ss = data.split(",");
            index = 0;
            TreeNode node = d(ss);
            return node;
        }


        private TreeNode d(String[] ss) {
            if (index == ss.length) return null;
            String s = ss[index];
            index++;
            if (s.equals("null")) return null;
            TreeNode node = new TreeNode(Integer.parseInt(s));
            node.left = d(ss);
            node.right = d(ss);
            return node;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}







