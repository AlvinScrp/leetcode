package leetcode_jianzhioffer;

public class J65 {
    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     *
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new J65().add(100, -200));
        System.out.println(new J65().add(199, 201));
    }

    public int add(int a, int b) {
        return b == 0 ? a : add(a ^ b, (a & b) << 1);

    }
}
