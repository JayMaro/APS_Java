package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class No_448 {

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] numArray = new int[n+1];
        List<Integer> resList = new ArrayList<>();
        for (int num : nums) {
            numArray[num] = 1;
        }
        for (int i = 1; i<=n; i++) {
            if (numArray[i] == 0) {
                resList.add(i);
            }
        }
        return resList;
    }
}
