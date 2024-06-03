package baekjoon.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _00_No_2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] paperArray = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] row =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            paperArray[i] = row;
        }
        find(N, paperArray);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void find(int N, int[][] paperArray) {
        int color = paperArray[0][0];
        boolean isSame = true;
        for (int i = 0; i < N; i++) {
            if (!isSame) {
                break;
            }
            for (int j = 0; j < N; j++) {
                if (color != paperArray[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }
        if (!isSame) {
            int[][] inputArray;
            for (int i = 0; i < 2; i++) {
                inputArray = Arrays.copyOfRange(paperArray, (N / 2) * i, (N / 2) * (i + 1));
                for (int j = 0; j < 2; j++) {
                    int[][] resArray = inputArray.clone();
                    for (int k = 0; k < N / 2; k++) {
                        resArray[k] = Arrays.copyOfRange(inputArray[k], (N / 2) * j, (N / 2) * (j + 1));
                    }
                    find(N / 2, resArray);
                }
            }
        } else {
            if (color == 0) {
                white++;
            } else {
                blue++;
            }
        }
    }
}
