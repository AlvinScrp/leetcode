package lintcode;

public class Lint_254_drop_egg {

    public static void main(String[] args) {
        System.out.println(Math.floor(1.2));
    }

    public int dropEggs(int n) {
        if (n <= 0) return 0;
        return 1 + dropEggs(n - ((int) (Math.ceil(n))));
    }
}
