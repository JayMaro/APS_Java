package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _02_No_20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int start = 0;
        int end = 1;
        int maxCount = 0;
        int nowCount = 1;
        Map<String, Integer> numMap = new HashMap<>();
        for (int i = 1; i <= 100000; i++) {
            numMap.put(String.valueOf(i), 0);
        }
        String[] strNums = br.readLine().split(" ");
        numMap.put(strNums[0], 1);

        while (end < n) {
            int count = numMap.get(strNums[end]);
            if (count + 1 > k) {
                if (maxCount < nowCount) {
                    maxCount = nowCount;
                }
                while (!strNums[end].equals(strNums[start])) {
                    numMap.put(strNums[start], numMap.get(strNums[start]) - 1);
                    start++;
                    nowCount--;
                }
                numMap.put(strNums[start], numMap.get(strNums[start]) - 1);
                start++;
                nowCount --;
            }
            numMap.put(strNums[end], numMap.get(strNums[end]) + 1);
            nowCount++;
            end++;
        }
        if (maxCount < nowCount) {
            maxCount = nowCount;
        }
        System.out.println(maxCount);
    }
}
