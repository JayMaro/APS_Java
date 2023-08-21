package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_14467 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int[] cows = new int[11];
        int move = 0;
        Arrays.fill(cows, -1);
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            Integer[] cowMove = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            if (cows[cowMove[0]] == -1) {
                cows[cowMove[0]] = cowMove[1];
            } else if (cows[cowMove[0]] != cowMove[1]) {
                cows[cowMove[0]] = cowMove[1];
                move++;
            }
        }
        System.out.println(sb.append(move));
    }
}
