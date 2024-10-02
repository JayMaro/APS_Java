package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01_No_5212 {
    public static int[] xMove = new int[]{1, 0, -1, 0};
    public static int[] yMove = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] rnStr = br.readLine().split(" ");
        int r = Integer.parseInt(rnStr[0]);
        int c = Integer.parseInt(rnStr[1]);
        char[][] namhae = new char[r][c];
        char[][] resultArr = new char[r][c];
        int minX = c;
        int maxX = 0;
        int minY = r;
        int maxY = 0;
        for (int i = 0; i < r; i++) {
            char[] inputChars = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                namhae[i][j] = inputChars[j];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (namhae[i][j] == 'X') {
                    int seaCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int movedY = i + yMove[k];
                        int movedX = j + xMove[k];
                        if (movedX < 0
                            || movedX >= c
                            || movedY < 0
                            || movedY >= r
                            || namhae[movedY][movedX] == '.') {
                            seaCount++;
                        }
                    }
                    if (seaCount >= 3) {
                        resultArr[i][j] = '.';
                    } else {
                        resultArr[i][j] = 'X';
                    }
                } else {
                    resultArr[i][j] = '.';
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (resultArr[i][j] == 'X') {
                    if (minX > j) {
                        minX = j;
                    }
                    if (maxX < j) {
                        maxX = j;
                    }
                    if (minY > i) {
                        minY = i;
                    }
                    if (maxY < i) {
                        maxY = i;
                    }
                }
            }
        }

        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                sb.append(resultArr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
