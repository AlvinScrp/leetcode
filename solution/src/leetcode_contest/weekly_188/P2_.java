package leetcode_contest.weekly_188;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2_ {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};

        List<Boolean> hasApple = Arrays.asList(false,false,true,false,false,true,false);

        System.out.println(new P2_().minTime(7, edges, hasApple));
    }

    public static class Node {
        public List<Node> children;
        public int val;
        public boolean has = false;

        public Node(int val, boolean has) {
            this.val = val;
            this.has = has;
            children = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "(" + val + "," + has + ")";
        }
    }


    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < hasApple.size(); i++) {
            nodes.add(new Node(i, hasApple.get(i)));
        }
        for (int i = 0; i < edges.length; i++) {
            nodes.get(edges[i][0]).children.add(nodes.get(edges[i][1]));
        }
        Node root = nodes.get(0);

        int[] res = dfs(root);
        return res[0] << 1;

    }

    private int[] dfs(Node node) {
        if (node == null) return new int[]{0, 0};
        if (node.children == null || node.children.isEmpty()) {
            return new int[]{0, node.has ? 1 : 0};
        }

        int pathSum = 0;
        int apple = 0;
        for (Node child : node.children) {
            int childSum[] = dfs(child);
            if (childSum[1] > 0 || child.has) {
                pathSum += (childSum[0] + 1);
                apple = 1;
            }
        }
        return new int[]{pathSum, apple};
    }
}
