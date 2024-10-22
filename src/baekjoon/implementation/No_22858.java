package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_22858 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] si = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] di = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] now = new int[n+1];
        int[] temp = new int[n+1];
        System.arraycopy(si, 0, now, 1, n);
        while (k > 0) {
            for (int i = 1; i <= n; i++) {
                temp[di[i-1]] = now[i];
            }
            System.arraycopy(temp, 0, now, 0, n+1);
            k--;
        }
        for (int i = 1; i <= n; i++) {
            sb.append(now[i]).append(" ");
        }
        System.out.println(sb);
    }
}
