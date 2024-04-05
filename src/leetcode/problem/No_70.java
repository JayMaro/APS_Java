package leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// f(n) = f(n-1) + f(n-2)
public class No_70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        List<Integer> valueList = new ArrayList<>(Arrays.asList(0, 1, 2, 3));

        for (int i=3; i<n; i++) {
            valueList.add(valueList.get(i) + valueList.get(i-1));
        }
        return valueList.get(n);
    }
}
