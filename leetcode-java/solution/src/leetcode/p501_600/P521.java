package leetcode.p501_600;

public class P521 {

    public int findLUSlength(String a, String b) {

        return (a.equals(b)) ? -1 : Math.max(a.length(), b.length());

    }
}
