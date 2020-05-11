package leetcode;

import java.util.*;

public class P212 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(new P212().findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {

      List<String>  res = new LinkedList<>();
        if (board == null || board.length == 0 || board[0].length == 0) return res;
        int  m = board.length;
        int  n = board[0].length;
        int[][] f = new int[m][n];

        Trie  trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j,m,n, trie.root,res,f);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int i, int j,int m,int n,Node node,List<String> res,int[][] f) {


        if (0 <= i && i < m && 0 <= j && j < n && f[i][j] == 0) {

            char ch = board[i][j];
            node = node.child(ch);
            if (node == null) return;
            if (node.word!=null) {res.add(node.word);node.word=null;}
            f[i][j] = 1;
            dfs(board, i - 1, j,m,n, node,res,f);
            dfs(board, i + 1, j,m,n, node,res,f);
            dfs(board, i, j - 1,m,n, node,res,f);
            dfs(board, i, j + 1,m,n, node,res,f);
            f[i][j] = 0;
        }

    }

    public static class Node {
//        public char val;
        public String word;
//        public boolean isWord;
        public Map<Character, Node> children = new HashMap<>();

//        public Node(char val) {
////            this.val = val;
//        }
        public Node() {
//            this.val = val;
        }

        public Node child(char ch) {
            return children.get(ch);
        }
    }


    public static class Trie {
        Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {

            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] chars = word.toCharArray();
            Node node = root;

            int length = chars.length;
            for (int i = 0; i < length; i++) {
                char ch = chars[i];
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new Node());
                }
                node = node.children.get(ch);
                if (i == length - 1) {
//                    node.isWord = true;
                    node.word = word;
                }
            }

        }

//        /**
//         * Returns if the word is in the trie.
//         */
//        public boolean search(String word) {
//
//            Node node = searchPrefix(word);
//            return node != null && node.isWord;
//        }
//
//        /**
//         * Returns if there is any word in the trie that starts with the given prefix.
//         */
//        public boolean startsWith(String prefix) {
//            return searchPrefix(prefix) != null;
//        }
//
//
//        public Node searchPrefix(String prefix) {
//
//            char[] chars = prefix.toCharArray();
//            Node node = root;
//
//            int length = chars.length;
//            int i;
//            for (i = 0; i < length; i++) {
//                char ch = chars[i];
//                if (!node.children.containsKey(ch)) {
//                    return null;
//                }
//                node = node.children.get(ch);
//                if (i == length - 1) return node;
//
//            }
//            return null;
//
//        }
    }


}
