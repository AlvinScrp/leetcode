package leetcode_jianzhioffer;

public class J58_2 {
    public static void main(String[] args) {
        //输出: "cdefgab"
        System.out.println(new J58_2().reverseLeftWords("abcdefg", 2));
    }

    public String reverseLeftWords(String s, int n) {
        if (n > s.length() || n < 0) return s;
        return s.substring(n) + s.substring(0, n);
    }
}
