package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _00_No_14929 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> xList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        long sum = 0;
        long result = 0;
        for (int i = 0; i < n; i++) {
            sum += xList.get(i);
        }
        for (int i = 0; i < n; i++) {
            int now = xList.get(i);
            result += now * (sum - now);
            sum -= now;
        }
        System.out.println(result);
    }
}
