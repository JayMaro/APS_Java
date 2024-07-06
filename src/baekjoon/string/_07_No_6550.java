package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _07_No_6550 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            String[] input = s.split(" ");
            sb.append(isSubString(input[0], input[1]) ? "Yes" : "No").append("\n");
            if (!br.ready()) {
                break;
            }
        }
        System.out.println(sb);
    }

    private static boolean isSubString(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (sChars[sIndex] == tChars[tIndex]) {
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == s.length();
    }
}
