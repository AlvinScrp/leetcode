package leetcode_contest.weekly_190;

public class P1_5416 {

    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i love eating burger", "burgere"));

    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] ss = sentence.split(" ");
        for (int i = 0; i < ss.length; i++) {
            if (isPrefix(ss[i], searchWord)) return i + 1;
        }
        return -1;

    }

    private static boolean isPrefix(String s, String searchWord) {
        if (searchWord.length() > s.length()) return false;
        for (int i = 0; i < searchWord.length(); i++) {
            if (searchWord.charAt(i) != s.charAt(i)) return false;
        }
        return true;
    }
}
