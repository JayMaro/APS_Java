package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_15650 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new int[N+1];
        answer = new int[M];
        makeList(0);
        System.out.println(sb);
    }

    public static void makeList(int arrayIndex) throws IOException {
        if (arrayIndex == M) {
            for (int i = 0; i < answer.length ; i++) {
                sb.append(answer[i]);
                if (i != answer.length - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 1) {
                continue;
            }
            if (arrayIndex > 0 && answer[arrayIndex - 1] > i) {
                continue;
            }
            visited[i] = 1;
            answer[arrayIndex] = i;
            makeList(arrayIndex+1);
            answer[arrayIndex] = 0;
            visited[i] = 0;
        }
    }
}
