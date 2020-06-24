package leetcode_contest.biweekly_27;

import java.util.*;

public class P3 {

    public static void main(String[] args) {
        System.out.println(
                new P3().checkIfPrerequisite(
                        3,
                        new int[][]{{1, 2}, {1, 0}, {2, 0}},
                        new int[][]{{1, 0}, {1, 2}}));
    }

    class Node {
        int val;
        Set<Node> children;
        Set<Node> parents;
//        Set<Node> grandChildren;


        public Node(int val) {
            this.val = val;
            children = new HashSet<>();
            parents = new HashSet<>();
//            grandChildren = new HashSet<>();


        }

//        @Override
//        public String toString() {
//            StringBuilder sb = new StringBuilder();
//            sb.append("val" + val);
//            sb.append("children:");
//            for (Node child : children) {
//                sb.append(child.val + ",");
//            }
//            sb.append("grandChildren:");
//            for (Node child : grandChildren) {
//                sb.append(child.val + ",");
//            }
//            return sb.toString();
//        }
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int[] pre : prerequisites) {
            Node node1 = nodes[pre[0]];
            Node node2 = nodes[pre[1]];
            node1.children.add(node2);
            node2.parents.add(node1);
            appendGrandChildren(node1.parents, node2);
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(isPrerequisite(nodes[query[0]], nodes[query[1]]));
        }
        return ans;

    }

    private void appendGrandChildren(Set<Node> nodes, Node node2) {

        Set<Node> parents=new HashSet<>();
        for (Node node : nodes) {
            node.children.add(node2);
            parents.addAll(node.parents);
        }

        parents.removeAll(nodes);
        if(!parents.isEmpty()) {
            appendGrandChildren(parents, node2);
        }

    }

    private Boolean isPrerequisite(Node root, Node child) {
        return root.children.contains(child);
    }


}

