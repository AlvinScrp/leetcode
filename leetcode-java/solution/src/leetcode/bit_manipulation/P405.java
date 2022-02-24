package leetcode.bit_manipulation;

public class P405 {
    public static void main(String[] args) {
        System.out.println(new P405().toHex(-1));
    }

    public String toHex(int num) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        traverse(num, sb);
        return sb.toString();

    }

    private void traverse(int num, StringBuilder sb) {
        if (num == 0) return;
        traverse(num >>> 4, sb);
        int bit = num & 0xf;
        sb.append((char) (bit <= 9 ? ('0' + (bit - 0)) : ('a' + (bit - 10))));

    }
}
