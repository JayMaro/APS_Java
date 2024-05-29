package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01_No_2231 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String N = br.readLine();
        int numLen = N.length();
        int range = numLen*9;
        int num = Integer.parseInt(N);
        int result = 0;
        for (int i = 0; i <= range; i++) {
            int x = num-i;
            if (x <= 0) {
                break;
            }
            int res = calculate(x, numLen);
            if (res == num) {
                result = x;
            }
        }
        System.out.println(result);
    }

    private static int calculate(int x, int numLen) {
        int res = x;
        for (int i = numLen; i > 0; i--) {
            int b = (int) Math.pow(10, i);
            int s = (int) Math.pow(10, i-1);
            int r = x % b;
            int v = r / s;
            res += v;
        }
        return res;
    }
}
