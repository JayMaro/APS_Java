package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _03_No_1758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArray = new int[N];
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            numArray[i] = x;
        }
        Arrays.sort(numArray);
        int result = 0;
        int reverse = 0;
        for (int i = 0; i < N; i++) {
            result += (Math.max(numArray[i] - i, 0));
            reverse += (Math.max(numArray[N - (i + 1)] - i, 0));
        }
        System.out.println(Math.max(result, reverse));
    }
}
