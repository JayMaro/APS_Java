package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_4396 {

    public static int[] iList = new int[]{1, 1, 1, 0, 0, -1, -1, -1};
    public static int[] jList = new int[]{1, -1, 0, 1, -1, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] mineMap = new char[n][n];
        char[][] nowMap = new char[n][n];
        char[][] resMap = new char[n][n];
        boolean isMine = false;
        // 지뢰 입력
        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                mineMap[i][j] = row[j];
            }
        }
        // 현재 상태 입력
        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                nowMap[i][j] = row[j];
            }
        }
        // 주변 지뢰 갯수 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nowMap[i][j] == 'x') {
                    if (!isMine && mineMap[i][j] == '*') {
                        isMine = true;
                    }
                    resMap[i][j] = (char) (countMine(i, j, n, mineMap) + 48);
                } else {
                    resMap[i][j] = '.';
                }
            }
        }
        // 지뢰를 밟았을 때
        if (isMine) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mineMap[i][j] == '*') {
                        resMap[i][j] = '*';
                    }
                }
            }
        }
        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(resMap[i][j]);
            }
            System.out.println();
        }
    }

    public static int countMine(int i, int j, int n, char[][] mineMap) {
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + iList[k];
            int y = j + jList[k];
            if (x >= 0 && x < n &&
                y >= 0 && y < n &&
                mineMap[x][y] == '*') {
                count++;
            }
        }
        return count;
    }
}
