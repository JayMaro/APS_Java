package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1913 {

    public static int xPosition = 0;
    public static int yPosition = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        arr[n/2][n/2] = 1;
        xPosition = n/2+1;
        yPosition = n/2+1;
        fillArr(n /2, 2, 1, arr, t);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(xPosition).append(" ").append(yPosition);
        System.out.println(sb);
    }

    public static void fillArr(int x, int now, int n, int[][] arr, int t) {
        if (x == 0) {
            return;
        }
        int tempNow = now;
        for (int k = x; k <= n + x; k++) {
            arr[x-1][k] = tempNow++;
            if (tempNow == t+1) {
                xPosition = x;
                yPosition = k+1;
            }
        }
        for (int k = x; k <= n + x; k++) {
            arr[k][n + x] = tempNow++;
            if (tempNow == t+1) {
                xPosition = k+1;
                yPosition = n+x+1;
            }
        }
        for (int k = n + x - 1; k >= x-1; k--) {
            arr[n + x][k] = tempNow++;
            if (tempNow == t+1) {
                xPosition = n+x+1;
                yPosition = k+1;
            }
        }
        for (int k = n + x - 1; k >= x-1; k--) {
            arr[k][x-1] = tempNow++;
            if (tempNow == t+1) {
                xPosition = k+1;
                yPosition = x;
            }
        }
        fillArr(x-1, tempNow, n+2, arr, t);
    }
}
