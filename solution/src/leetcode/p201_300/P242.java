package leetcode.p201_300;

public class P242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(Integer.MAX_VALUE);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] ans = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i)-'a'] ++;
        }

        for (int i = 0; i < t.length(); i++) {
            ans[s.charAt(i)-'a'] --;
            if(ans[s.charAt(i)-'a']<0) return false;
        }
        return true;

    }

}
