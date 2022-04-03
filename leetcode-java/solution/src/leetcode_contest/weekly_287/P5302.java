package leetcode_contest.weekly_287;

import java.util.HashMap;
import java.util.Map;

public class P5302 {

    public static void main(String[] args) {
//        System.out.println(new P1().minDeletion(new int[]{1, 1, 2, 2, 3, 3}));
//        char[] keys = new char[]{'a', 'b', 'c', 'd'};
//        String[] values = new String[]{"ei", "zf", "ei", "am"};
//        String[] dictionary = new String[]{"abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"};
//        Encrypter obj = new Encrypter(keys, values, dictionary);
//        System.out.println(obj.encrypt("abcd"));
//        System.out.println(obj.decrypt("eizfeiam"));


        char[] keys = new char[]{'a', 'b', 'c', 'z'};
        String[] values = new String[]{"aa", "bb", "cc", "zz"};
        String[] dictionary = new String[]{"aa", "aaa", "aaaa", "aaaaa", "aaaaaaa"};
        Encrypter obj = new Encrypter(keys, values, dictionary);
        System.out.println(obj.decrypt("aaaa"));
        System.out.println(obj.decrypt("aa"));
        System.out.println(obj.decrypt("aaaa"));
        System.out.println(obj.decrypt("aaaaaaaa"));
        System.out.println(obj.decrypt("aaaaaaaaaaaaaa"));
        System.out.println(obj.decrypt("aefagafvabfgshdthn"));
//[null,1,0,1,1,1,0]
//        System.out.println(obj.decrypt("aa"));
    }

}

class Encrypter {
    Map<Character, String> k2v = new HashMap<>();
    Map<String, Integer> eCount = new HashMap<>();

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for (int i = 0; i < keys.length; i++) {
            k2v.put(keys[i], values[i]);
        }
        for (String s : dictionary) {
            String e = encrypt(s);
            eCount.put(e, eCount.getOrDefault(e, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            sb.append(k2v.get(word1.charAt(i)));
        }
        return sb.toString();

    }

    public int decrypt(String word2) {
        return eCount.getOrDefault(word2, 0);
    }

}
