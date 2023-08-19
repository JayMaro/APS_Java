package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_10815 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Integer[] sortedArray = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .sorted()
            .toArray(Integer[]::new);
        int M = Integer.parseInt(br.readLine());
        Integer[] targetArray = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .toArray(Integer[]::new);
        for (Integer target : targetArray) {
            int index = Arrays.binarySearch(sortedArray, target);
            if (index >= 0) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

}
