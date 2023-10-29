package leetcode.tutorial;

import java.util.Arrays;

public class No_1480 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
    }

    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1 ; i < nums.length ; i ++) {
            result[i] = nums[i] + result[i-1];
        }
        return result;
    }
}