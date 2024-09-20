package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _No_11585 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String p = br.readLine().replaceAll(" ", "");
        String s = br.readLine().replaceAll(" ", "");
        System.out.println(KMP(s, p));
    }

    private static String KMP(String s, String p) {
        int[] pi = getPi(p);
        for (int i : pi) {
            System.out.println(i);
        }
        return "";
    }

    private static int[] getPi(String p) {
        int[] pi = new int[p.length()];
        int j = 0;
        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j-1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
