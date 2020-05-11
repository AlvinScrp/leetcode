package leetcode;

public class P153 {

    public static void main(String[] args) {
        System.out.println(new P153().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new P153().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new P153().findMin(new int[]{2, 3, 1}));
        System.out.println(new P153().findMin(new int[]{1,2, 3}));
    }

    /**
     * [3,4,5,6,7,1,2]
     * [6,7,1,2,3,4,5]
     *
     * @param numbers
     * @return
     */
    public int findMin(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;
        return minArray(numbers, 0, numbers.length - 1);
    }

    private int minArray(int[] num, int left, int right) {
        if (left == right) return num[right];
        if (num[left] < num[right]) return num[left];
        int middle = (right - left) / 2 + left;
        if (num[middle] > num[right]) {
            return minArray(num, middle + 1, right);
        } else {
            return minArray(num, left, middle);
        }
    }
}
