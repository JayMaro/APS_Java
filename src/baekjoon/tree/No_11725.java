package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class No_11725 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> parentList = new ArrayList<>(N+1);
        Map<Integer, Set<Integer>> childMap = new HashMap<>();
        for (int i = 0; i < N+1; i++) {
            parentList.add(0);
            childMap.put(i, new HashSet<>());
        }
        for (int i = 1; i < N; i++) {
            List<Integer> collect = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            childMap.get(collect.get(0)).add(collect.get(1));
            childMap.get(collect.get(1)).add(collect.get(0));
        }
        LinkedList<Integer> parentQueue = new LinkedList<>();
        parentQueue.add(1);
        while (!parentQueue.isEmpty()) {
            Integer parent = parentQueue.removeFirst();
            Set<Integer> childes = childMap.get(parent);
            for (Integer child : childes) {
                childMap.get(child).remove(parent);
                parentList.set(child, parent);
                parentQueue.addLast(child);
            }
        }
        for (int i = 2; i < N+1 ; i++) {
            System.out.println(parentList.get(i));
        }
    }
}
