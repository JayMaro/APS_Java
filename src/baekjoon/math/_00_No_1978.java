package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _00_No_1978 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> primeNumList = new ArrayList<>();
        primeNumList.add(2);
        primeNumList.add(3);
        int result = 0;

        for (int i = 5; i <= 1000; i += 2) {
            boolean isPrime = true;
            for (int prim : primeNumList) {
                if (i % prim == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumList.add(i);
            }
        }
        List<Integer> numList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        for (Integer num : numList) {
            if (primeNumList.contains(num)) {
                result++;
            }
        }
        System.out.println(result);
    }
}
