package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _01_No_1260 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Integer> inputList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int N = inputList.get(0); // 정점
        int M = inputList.get(1); // 간선
        int V = inputList.get(2); // 시작점

        Map<Integer, List<Integer>> graphMap = makeDefaultMap(N);
        addGraphAndSort(M, graphMap);
        DFS(N, V, graphMap);
        BFS(N, V, graphMap);
    }

    private static void addGraphAndSort(int M, Map<Integer, List<Integer>> graphMap) throws IOException {
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            // 양방향
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            graphMap.get(start).add(end);
            graphMap.get(end).add(start);
        }
        // 정렬
        for (List<Integer> integerList : graphMap.values()) {
            integerList.sort((a, b) -> a - b);
        }
    }

    private static Map<Integer, List<Integer>> makeDefaultMap(int N) {
        Map<Integer, List<Integer>> graphMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graphMap.put(i, new ArrayList<>());
        }
        return graphMap;
    }

    private static void DFS(int N, int V, Map<Integer, List<Integer>> graphMap) {
        LinkedList<Integer> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int[] isVisitArray = new int[N+1];
        stack.add(V);
        while (!stack.isEmpty()) {
            int val = stack.removeLast();
            if (isVisitArray[val] == 1) {
                continue;
            } else {
                isVisitArray[val] = 1;
                result.add(val);
            }
            for (int i = graphMap.get(val).size()-1; i >= 0; i--) {
                int node = graphMap.get(val).get(i);
                if (isVisitArray[node] == 0) {
                    stack.add(node);
                }
            }
        }
        for (int res : result) {
            System.out.print(res);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void BFS(int N, int V, Map<Integer, List<Integer>> graphMap) {
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int[] isVisitArray = new int[N+1];
        queue.add(V);
        while (!queue.isEmpty()) {
            int val = queue.removeFirst();
            if (isVisitArray[val] == 1) {
                continue;
            } else {
                isVisitArray[val] = 1;
                result.add(val);
            }
            for (int node : graphMap.get(val)) {
                if (isVisitArray[node] == 0) {
                    queue.addLast(node);
                }
            }
        }
        for (int res : result) {
            System.out.print(res);
            System.out.print(" ");
        }
        System.out.println();
    }
}
