package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _00_No_11728 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] inputSize = br.readLine().split(" ");
        int N = Integer.parseInt(inputSize[0]);
        int M = Integer.parseInt(inputSize[1]);
        List<Integer> list1 = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        int index1 = 0;
        int index2 = 0;
        List<Integer> result = new ArrayList<>();
        while (index1 < N && index2 < M) {
            if (list1.get(index1) < list2.get(index2)) {
                result.add(list1.get(index1++));
            } else {
                result.add(list2.get(index2++));
            }
        }
        while (index1 < N) {
            result.add(list1.get(index1++));
        }
        while (index2 < M) {
            result.add(list2.get(index2++));
        }
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
