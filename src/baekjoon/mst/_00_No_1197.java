package baekjoon.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _00_No_1197 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int V = Integer.parseInt(inputs[0]);
        int E = Integer.parseInt(inputs[1]);
        int[] visited = new int[V + 1];
        int total = 0;

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 1; i < V+1; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            String[] eInfo = br.readLine().split(" ");
            int a = Integer.parseInt(eInfo[0]);
            int b = Integer.parseInt(eInfo[1]);
            int val = Integer.parseInt(eInfo[2]);
            List<int[]> aList = map.get(a);
            aList.add(new int[]{a, b, val});
            List<int[]> bList = map.get(b);
            bList.add(new int[]{b, a, val});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        visited[1] = 1;
        List<int[]> initList = map.get(1);
        queue.addAll(initList);
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int target = data[1];
            int val = data[2];
            if (visited[target] == 1) {
                continue;
            }
            visited[target] = 1;
            total += val;
            for (int[] iArray : map.get(target)) {
                if (visited[iArray[1]] == 0) {
                    queue.add(iArray);
                }
            }
        }

        System.out.println(total);

    }


}
