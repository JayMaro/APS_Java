package leetcode.problem;

import java.util.HashMap;

public class No_217_Contains_Duplicate {

    public static void main(String[] args) {
        boolean res = containsDuplicate(new int[]{1, 2, 3, 1});
        System.out.println(res);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int number : nums) {
            int findNumber = hashMap.getOrDefault(number, 0);
            if (findNumber > 0) return true;
            hashMap.put(number, 1);
        }
        return false;
    }

}
