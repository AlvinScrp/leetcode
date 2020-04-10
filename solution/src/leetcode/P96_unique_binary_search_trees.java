package leetcode;

public class P96_unique_binary_search_trees {
    public static void main(String[] args) {
//        System.out.println(numTrees(0));
//        System.out.println(numTrees(1));
//        System.out.println(numTrees(2));
//        System.out.println(numTrees(3));
//        System.out.println(numTrees(4));
        System.out.println(numTrees(19));

    }

    public static int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = 2 * (2 * i - 1) * result/ (i + 1) ;
        }
        return (int) result;

    }
}
