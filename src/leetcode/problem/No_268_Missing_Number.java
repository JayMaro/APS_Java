package leetcode.problem;

public class No_268_Missing_Number {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber(new int[]{0,1}));
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int[] numberList = new int[n+1];
        for (int num : nums) {
            numberList[num] = 1;
        }
        for (int i = 0; i<=n; i++) {
            if (numberList[i] == 0) return i;
        }
        return 0;
    }
}
