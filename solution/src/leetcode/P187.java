package leetcode;

import java.util.*;

public class P187 {
    /**
     * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，
     * 例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
     * <p>
     * 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
     * <p>
     * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
     *
     * @return
     */
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }


//    public static List<String> findRepeatedDnaSequences(String s) {
//        List<String> res = new ArrayList<>();
//        if (s == null || s.length() <=0) return new ArrayList<>();
//        HashMap<String,Integer> map=new HashMap<>();
//        for (int i = 0; i <= s.length() - 10; i++) {
//            String si=s.substring(i, i + 10);
//            map.put(si,map.getOrDefault(si,0)+1);
//        }
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if(entry.getValue()>1) res.add(entry.getKey());
//        }
//        return res;
//    }


    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() <= 10) return new ArrayList<>();
        HashMap<Integer, Integer> bitStarts = new HashMap<>();
        HashMap<Integer, Integer> bitCounts = new HashMap<>();

        int[] bitKey = new int[128];
        bitKey['A'] = 0;
        bitKey['C'] = 1;
        bitKey['G'] = 2;
        bitKey['T'] = 3;
        int mask = 0b01111111111100000000000000000000;

        int bits = 0;
        for (int i = 0; i < 9; i++) {
            bits = (bits << 2) | bitKey[s.charAt(i)]|mask;
        }
        for (int i = 9; i < s.length(); i++) {
            bits = (bits << 2) | bitKey[s.charAt(i)]|mask;

            bitCounts.put(bits, bitCounts.getOrDefault(bits, 0) + 1);
            if (bitCounts.get(bits) == 2) bitStarts.put(bits, i - 9);
        }
        for (Integer start : bitStarts.values()) {
            res.add(s.substring(start, start + 10));
        }

        return res;
    }
}
