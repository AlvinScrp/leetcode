package leetcode.p1_100;

public class P11_container_with_most_water {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
        System.out.println(maxArea2(height));
    }

    public static int maxArea(int[] height) {

        int length = height.length;
        if (length == 0 || length == 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                max = Math.max((j - i) * Math.min(height[i], height[j]), max);
            }
        }
        return max;

    }

    public static int maxArea2(int[] height) {

        int length = height.length;
        if (length == 0 || length == 1) {
            return 0;
        }
        int max = 0,  left=0,right=length-1;
        while (left!=right){
            max = Math.max((right - left) * Math.min(height[left], height[right]), max);
            if(height[left]< height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;

    }
}
