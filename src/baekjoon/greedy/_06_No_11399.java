package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _06_No_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] timeArr = new int[n];
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            timeArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(timeArr);
        for (int i = 0; i < n; i++) {
            sum += ((long)timeArr[i] * (n-i));
        }
        System.out.println(sum);
    }
}
