package leetcode.p101_200;

import java.util.ArrayList;
import java.util.List;

public class P151 {

    public static void main(String[] args) {
        System.out.println(new P151().reverseWords("  its    hello   world!  "));
    }

    public String reverseWords(String s) {
        s = s.trim();
        if (s.isEmpty()) return "";

        List<String> words = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            int j = i;
            for (; j < s.length() && s.charAt(j) != ' '; j++) ;
            words.add(0, s.substring(i, j));
            i = j + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
