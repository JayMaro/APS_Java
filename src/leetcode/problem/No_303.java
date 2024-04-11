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

        class NumArray2 {

            int[] sums;
            int[] nums;

            public NumArray2(int[] nums) {
                this.nums = nums;
                this.sums = new int[nums.length];
                this.sums[0] = nums[0];

                for (int i=1; i<nums.length; i++){
                    this.sums[i] = this.sums[i-1] + nums[i];
                }
            }

            public int sumRange(int left, int right) {
                return this.sums[right] - this.sums[left] + this.nums[left];
            }
        }

        NumArray2 obj2 = new NumArray2(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj2.sumRange(0,2));
        System.out.println(obj2.sumRange(2,5));
        System.out.println(obj2.sumRange(0,5));

    }


}
