package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _04_No_11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int count = 0;
        int now = k;
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n-1; i >= 0; i--) {
            while (now - coins[i] >= 0) {
                count ++;
                now -= coins[i];
            }
            if (now == 0) {
                break;
            }
        }
        System.out.println(count);
    }
}
