package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _04_No_16916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String S = br.readLine();
        String P = br.readLine();
        System.out.println(KMP(S, P));
    }

    private static int KMP(String S, String P) {
        int[] pi = getPI(P);
        int lenS = S.length();
        int lenP = P.length();

        int idx = 0;
        for (int i = 0; i < lenS; i++) {
            while (idx > 0 && S.charAt(i) != P.charAt(idx)) {
                idx = pi[idx - 1];
            }
            if (S.charAt(i) == P.charAt(idx)) {
                if (idx == lenP - 1) {
                    return 1;
                } else {
                    idx += 1;
                }
            }
        }
        return 0;
    }

    private static int[] getPI(String pattern) {
        int len = pattern.length();
        int j = 0;
        int[] pi = new int[len];
        for (int i = 1; i < len; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
