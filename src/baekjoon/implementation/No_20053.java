package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class No_20053 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        int caseNumber = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseNumber; i++) {
            int numberCount = Integer.parseInt(br.readLine());
            List<Integer> numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int minVal = 1000000;
            int maxVal = -1000000;
            for (int number : numbers) {
                if (number > maxVal) {
                    maxVal = number;
                }
                if (number < minVal) {
                    minVal = number;
                }
            }
            sb.append(minVal).append(" ").append(maxVal).append("\n");
        }
        System.out.print(sb);
    }

}
