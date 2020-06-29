package leetcode.p101_200;

import java.util.*;

public class P127 {

    public static void main(String[] args) {
        System.out.println(new P127().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }


    Map<String, Set<String>> map = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || wordList.isEmpty()) return 0;


        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (canLadder(wordList.get(i), wordList.get(j))) {
                    ladder(map, wordList.get(i), wordList.get(j));
                    ladder(map, wordList.get(j), wordList.get(i));
                }
            }
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (canLadder(beginWord, wordList.get(i))) {
                ladder(map, beginWord, wordList.get(i));
            }
        }
        Set<String> words = new HashSet<>();
        words.add(beginWord);
        return bfs(words, endWord, 1, wordList.size() + 1);
//        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }

    private int bfs(Set<String> words, String endWord, int step, int max) {

        if (step == max||words.isEmpty()) {
            return 0;
        }

        for (String word : words) {
            if (canLadderCache(word, endWord)) return step + 1;
        }

        Set<String> words2 = new HashSet<>();
        for (String word : words) {
            words2.addAll(map.getOrDefault(word, new HashSet<>()));
        }
        return bfs(words2, endWord, step + 1, max);
    }

    private boolean canLadderCache(String beginWord, String endWord) {
        return map.containsKey(beginWord) && map.get(beginWord).contains(endWord);
    }

    private boolean canLadder(String word1, String word2) {
        int count = 0;
        for (int k = 0; k < word1.length(); k++) {
            if (word1.charAt(k) != word2.charAt(k)) {
                count++;
                if (count > 1) break;
            }
        }
        return count == 1;
    }

    private void ladder(Map<String, Set<String>> map, String word1, String word2) {
        if (!map.containsKey(word1)) {
            map.put(word1, new HashSet<>());
        }
        map.get(word1).add(word2);
    }
}
