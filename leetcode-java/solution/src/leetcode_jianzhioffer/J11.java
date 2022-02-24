package leetcode_jianzhioffer;

public class J11 {

    /**
     * [3,4,5,6,7,1,2]
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;
        return minArray(numbers, 0, numbers.length - 1);
    }

    private int minArray(int[] num, int left, int right) {
        if (left == right) return num[right];
        if (num[left] < num[right]) return num[left];
        int middle = (right - left) / 2 + left;

        if (num[middle] == num[right]) {
            return minArray(num, left, right-1);
        } else if (num[middle] > num[right]) {
            return minArray(num, middle + 1, right);
        } else {
            return minArray(num, left, middle);
        }
    }
}
