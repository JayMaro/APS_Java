package leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class No_338 {

    public static void main(String[] args) {
        for (int num: countBits(16)) {
            System.out.println(num);
        }

    }

    public static int[] countBits(int n) {
        int multiple2 = 2;
        int count = 1;
        while (n > multiple2) {
            multiple2 *= 2;
            count++;
        }
        List<Integer> numList = new ArrayList<>(Arrays.asList(0, 1, 1));
        for (int i=1; i < count; i++) {
            List<Integer> temp = numList.stream().map(num -> num+1).collect(Collectors.toList());
            numList.addAll(temp.subList(1, temp.size()-1));
            numList.add(1);
        }
        return numList.subList(0, n+1).stream().mapToInt(i -> i).toArray();
    }
}
