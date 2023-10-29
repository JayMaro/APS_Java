package leetcode.tutorial;

import java.util.Arrays;

public class No_1672 {

    public static void main(String[] args) {

    }

    public static int maximumWealth(int[][] accounts) {
        int maxValue = 0;
        for (int[] ownAccounts : accounts) {
            int sum = Arrays.stream(ownAccounts).sum();
            if (maxValue < sum) {
                maxValue = sum;
            }
        }
        return maxValue;
    }
}
