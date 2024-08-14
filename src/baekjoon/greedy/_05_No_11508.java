package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _05_No_11508 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(n, (a,b) -> b-a);
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            priorityQueue.add(num);
        }
        for (int i = 1; i < n+1; i++) {
            Integer price = priorityQueue.poll();
            if (i % 3 == 0) {
                continue;
            }
            sum += price;
        }
        System.out.println(sum);
    }
}
