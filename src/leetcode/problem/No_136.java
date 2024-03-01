package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

public class No_136 {

    public static void main(String[] args) {

    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            if (numMap.getOrDefault(num, 0) == 0) {
                numMap.put(num, 1);
            } else {
                numMap.remove(num);
            }
        }
        return numMap.keySet().iterator().next();
    }
}
