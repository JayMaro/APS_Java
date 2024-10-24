package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_17276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringBuilder sb = new StringBuilder();
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int d = Integer.parseInt(s[1]);
            int rotate = (d % 360) / 45;
            String[][] before = new String[n][n];
            String[][] now = new String[n][n];
            for (int i = 0; i < n; i++) {
                before[i] = br.readLine().split(" ");
            }
            if (rotate < 0) {
                while (rotate != 0) {
                    leftSpin(before, now);
                    before = now;
                    now = new String[n][n];
                    rotate++;
                }
            } else {
                while (rotate != 0) {
                    rightSpin(before, now);
                    before = now;
                    now = new String[n][n];
                    rotate--;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(before[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }

    public static void rightSpin(String[][] before, String[][] now) {
        int length = before.length;
        int half = length / 2;
        for (int i = 0; i < length; i++) {
            now[i][half] = before[i][i];
            now[i][length - i - 1] = before[i][half];
            now[half][length - i - 1] = before[i][length - i- 1];
            now[i][i] = before[half][i];
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (now[i][j] == null) {
                    now[i][j] = before[i][j];
                }
            }
        }
    }

    public static void leftSpin(String[][] before, String[][] now) {
        int length = before.length;
        int half = length / 2;
        for (int i = 0; i < length; i++) {
            now[i][i] = before[i][half];
            now[i][half] = before[i][length - i- 1];
            now[i][length - i- 1] = before[half][length - i- 1];
            now[half][i] = before[i][i];
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (now[i][j] == null) {
                    now[i][j] = before[i][j];
                }
            }
        }
    }
}
