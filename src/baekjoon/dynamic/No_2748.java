package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No_2748 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] result = new long[n+2];
        result[0] = 0;
        result[1] = 1;
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                result[i] = fibonachi(i, result);
            }
        }
        bw.write(String.valueOf(result[n]));
        bw.flush();
    }

    public static long fibonachi(int target, long[] result) {
        long n_2 = result[target-2];
        long n_1 = result[target-1];
        return n_1 + n_2;
    }
}
