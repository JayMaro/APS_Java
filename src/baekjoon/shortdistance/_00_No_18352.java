package baekjoon.shortdistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _00_No_18352 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        // 목표 최단 거리
        int K = Integer.parseInt(input[2]);
        // 출발 도시 번호
        int X = Integer.parseInt(input[3]);
        Map<Integer, List<Integer>> roadMap = new HashMap<>();

        for (int i = 0; i < M; i++) {
            String[] inputLine = br.readLine().split(" ");
            int x = Integer.parseInt(inputLine[0]);
            int y = Integer.parseInt(inputLine[1]);
            List<Integer> xRoad = roadMap.getOrDefault(x, new ArrayList<>());
            xRoad.add(y);
            roadMap.put(x, xRoad);
        }

        LinkedList<int[]> queue = new LinkedList<>();
        int[] visited = new int[N + 1];
        queue.addFirst(new int[]{0, X});
        visited[X] = 1;
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] output = queue.removeLast();
            int distance = output[0];
            int node = output[1];
            if (distance == K) {
                result.add(node);
            }
            List<Integer> roads = roadMap.getOrDefault(node, new ArrayList<>());
            for (Integer road : roads) {
                if (visited[road] != 1) {
                    visited[road] = 1;
                    queue.addFirst(new int[]{distance+1, road});
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            result.sort((a, b) -> a-b);
            result.forEach(System.out::println);
        }
    }
}
