package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _2_02_No_11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(N, (a, b) -> b - a);
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("0")) {
                Integer maxNum = pq.poll();
                sb.append(maxNum == null ? 0 : maxNum);
                sb.append("\n");
            } else {
                pq.add(Integer.parseInt(input));
            }
        }
        System.out.println(sb);
    }
}
