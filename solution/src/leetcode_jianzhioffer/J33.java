package leetcode_jianzhioffer;

public class J33 {

    public static void main(String[] args) {
        System.out.println(  new J33().verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        System.out.println( new J33().verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    /**
     *  /**
     *      * 参考以下这颗二叉搜索树：
     *      * <p>
     *      * 5
     *      * / \
     *      * 2   6
     *      * / \
     *      * 1   3
     *      * <p>
     *      * <p>
     *      * 输入: [1,6,3,2,5]
     *      * 输出: false
     *      * <p>
     *      * 输入: [1,3,2,6,5]
     *      * 输出: true
     *      *
     *      * @return
     *      */

    public boolean verifyPostorder(int[] postorder) {
        if(postorder==null) return false;
        return verify(postorder, 0, postorder.length - 1);

    }



    private boolean verify(int[] postorder, int start, int end) {
        if (start == end) return true;

        int i = end - 1;
        while (i >= start && postorder[i] > postorder[end]) {
            i--;
        }
        int j = i;
        while (j >= start && postorder[j] < postorder[end]) {
            j--;
        }
        if (j >= start) return false;
        if (i < end - 1 && !verify(postorder, i + 1, end - 1)) {
            return false;
        }
        if (i >= start && !verify(postorder, start, i)) {
            return false;
        }
        return true;
    }
}
