package leetcode.p201_300;

import java.util.*;

public class P208 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
//        System.out.println(new P208().findWords(board, words));
    }




    public static class Trie {


        public static class Node {
            //        public char val;
//        public String word;
            public boolean isWord;
            public Map<Character, Node> children = new HashMap<>();

            //        public Node(char val) {
////            this.val = val;
//        }
            public Node() {
//            this.val = val;
            }

//        public Node child(char ch) {
//            return children.get(ch);
//        }
        }



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
                    node.isWord = true;
//                    node.word = word;
                }
            }

        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {

            Node node = searchPrefix(word);
            return node != null && node.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }


        public Node searchPrefix(String prefix) {

            char[] chars = prefix.toCharArray();
            Node node = root;

            int length = chars.length;
            int i;
            for (i = 0; i < length; i++) {
                char ch = chars[i];
                if (!node.children.containsKey(ch)) {
                    return null;
                }
                node = node.children.get(ch);
                if (i == length - 1) return node;

            }
            return null;

        }
    }


}
