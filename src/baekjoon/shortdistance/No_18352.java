package baekjoon.shortdistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No_18352 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        // 목표 최단 거리
        int K = Integer.parseInt(input[2]);
        // 출발 도시 번호
        int X = Integer.parseInt(input[3]);
        int[][] roadMap = new int[N + 1][N + 1];
        int[] visited = new int[N + 1];
        int[] xDistance;
        int INF = 1000000;
        for (int i = 0; i < M; i++) {
            String[] inputLine = br.readLine().split(" ");
            int x = Integer.parseInt(inputLine[0]);
            int y = Integer.parseInt(inputLine[1]);
            roadMap[x][y] = 1;
            roadMap[y][x] = 1;
        }
        xDistance = roadMap[X];
        // 번호, 거리
        LinkedList<int[]> distanceList = new LinkedList<>();
        visited[X] = 1;
        for (int i = 1; i < N+1; i++) {
            if (xDistance[i] == 0) {
                xDistance[i] = INF;
            } else {
                distanceList.addLast(new int[]{i, 1});
                visited[i] = 1;
            }
        }
        while (!distanceList.isEmpty()) {
            int[] item = distanceList.removeFirst();
            int number = item[0];
            int distance = item[1];
            int[] numberDistance = roadMap[number];
            for (int i = 1; i < N+1; i++) {
                if (visited[i] == 1) {
                    continue;
                }
                int sumDistance = distance + numberDistance[i];
                if (sumDistance > xDistance[i]) {
                    continue;
                }
                visited[i] = 1;
                xDistance[i] = sumDistance;
                distanceList.addLast(new int[]{i, sumDistance});
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < N+1; i++) {
            if (xDistance[i] == K) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            sb.append(-1);
        } else {
            for (Integer integer : answer) {
                sb.append(integer);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
