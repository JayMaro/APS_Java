package leetcode.problem;

public class No_303 {

    public static void main(String[] args) {
        class NumArray {

            int[] nums;

            public NumArray(int[] nums) {
                this.nums = nums;
            }

            public int sumRange(int left, int right) {
                int sumVal = 0;
                for (int i=left; i<=right; i++) {
                    sumVal += this.nums[i];
                }
                return sumVal;
            }
        }

        NumArray obj = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(2,5));
        System.out.println(obj.sumRange(0,5));


    }


}
