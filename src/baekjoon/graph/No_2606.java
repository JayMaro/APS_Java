package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class No_2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Map<Integer, Set<Integer>> graphMap = new HashMap<>();
        int[] visited = new int[N+1];

        for (int i = 1; i < N + 1; i++) {
            graphMap.put(i, new HashSet<>());
        }
        for (int i = 0; i < M; i++) {
            List<Integer> collect = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            graphMap.get(collect.get(0)).add(collect.get(1));
            graphMap.get(collect.get(1)).add(collect.get(0));
        }
        int answer = 0;
        LinkedList<Integer> infestedList = new LinkedList<>();
        infestedList.add(1);
        visited[1] = 1;
        while (!infestedList.isEmpty()) {
            Integer infestedNumber = infestedList.removeFirst();
            Set<Integer> infestedSet = graphMap.get(infestedNumber);
            for (Integer infested : infestedSet) {
                if (visited[infested] == 1) {
                    continue;
                }
                visited[infested] = 1;
                infestedList.addLast(infested);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
