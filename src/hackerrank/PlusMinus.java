package hackerrank;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PlusMinus {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
        plusMinus(n, arr);

        bufferedReader.close();
    }

    public static void plusMinus(int n, List<Integer> arr) {
        // Write your code here
        double plusNums = 0;
        double zeroNums = 0;
        double minusNums = 0;
        for (int num : arr) {
            if (num > 0) {
                plusNums += 1d;
            } else if (num < 0) {
                minusNums += 1d;
            } else {
                zeroNums += 1d;
            }
        }
        double N = (double) n;
        System.out.printf("%-6f", plusNums / N);
        System.out.println();
        System.out.printf("%-6f", minusNums / N);
        System.out.println();
        System.out.printf("%-6f", zeroNums / N);
    }
}
