package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _03_No_9934 {

    public static int[] node;
    public static ArrayDeque<Integer> orderQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        int N = (int) Math.pow(2, K);
        orderQueue = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toCollection(ArrayDeque::new));
        node = new int[N];
        preOrder(1, N);
        for (int i = 0; i < K; i++) {
            for (int j = (int) Math.pow(2, i); j < (int) Math.pow(2, i + 1); j++) {
                sb.append(node[j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void preOrder(int val, int N) {
        if (val * 2 < N && node[val * 2] == 0) {
            preOrder(val * 2, N);
        }
        if (node[val] == 0) {
            node[val] = orderQueue.removeFirst();
        }
        if ((val * 2) + 1 < N && node[(val * 2) + 1] == 0) {
            preOrder((val * 2) + 1, N);
        }
    }

}
