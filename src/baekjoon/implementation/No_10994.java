package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10994 {

    public static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int count = 1 + 4 * (n-1);
        arr = new char[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                arr[i][j] = ' ';
            }
        }
        makeStar(0, count-1);
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void makeStar(int start, int end) {
        if ((end - start) < 0) {
            return;
        }
        for (int i = start; i <= end; i++) {
            arr[start][i] = '*';
            arr[i][start] = '*';
            arr[end][i] = '*';
            arr[i][end] = '*';
        }

        makeStar(start + 2, end - 2);
    }
}
