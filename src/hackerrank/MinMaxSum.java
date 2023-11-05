package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MinMaxSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        miniMaxSum(arr);
        bufferedReader.close();
    }

    public static void miniMaxSum(List<Long> arr) {
        // Write your code here
        long sum = 0;
        long max = 0;
        long min = Long.MAX_VALUE;
        for (long num : arr) {
            sum += num;
        }
        for (long num : arr) {
            long nowSum = sum - num;
            if (nowSum > max) {
                max = nowSum;
            }
            if (nowSum < min) {
                min = nowSum;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        System.out.println(sb.toString());
    }
}

