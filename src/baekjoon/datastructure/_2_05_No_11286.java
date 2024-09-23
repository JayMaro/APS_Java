package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _2_05_No_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) - Math.abs(b) == 0) {
                return a - b;
            } else {
                return Math.abs(a) - Math.abs(b);
            }
        });
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    Integer num = queue.poll();
                    sb.append(num).append("\n");
                }
            } else {
                queue.add(input);
            }
        }
        System.out.println(sb);
    }
}
