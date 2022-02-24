package leetcode_contest.weekly_189;

import java.util.*;

public class P2_5413 {

    public static void main(String[] args) {

        System.out.println(new P2_5413().arrangeWords("Leetcode is cool"));
        System.out.println(new P2_5413().arrangeWords("Keep calm and code on"));

    }

    public String arrangeWords(String text) {
        if (text == null || text.isEmpty()) return "";


        String[] ss = text.split(" ");
        ss[0] = ss[0].toLowerCase();
        List<String> ss2 = Arrays.asList(ss);
        Collections.sort(ss2, Comparator.comparingInt(String::length));

        StringBuilder sb = new StringBuilder();
        String start = ss2.get(0);
        char[] chars = start.toCharArray();
        chars[0] = (char) (chars[0] + ('A' - 'a'));
        start = String.valueOf(chars);
        sb.append(start);
        for (int i = 1; i < ss2.size(); i++) {
            sb.append(" ");
            sb.append(ss2.get(i));
        }
        return sb.toString();
    }
}
