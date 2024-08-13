package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _02_No_11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n+1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        nodes[1].setParent(0);
        for (int i = 0; i < n - 1; i++) {
            String[] edges = br.readLine().split(" ");
            int a = Integer.parseInt(edges[0]);
            int b = Integer.parseInt(edges[1]);
            nodes[a].addEdge(b);
            nodes[b].addEdge(a);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            Integer parent = nodes[num].getParent();
            List<Integer> edgeList = nodes[num].getEdgeList();
            for (Integer edge : edgeList) {
                if (parent.equals(edge)) {
                    continue;
                }
                nodes[edge].setParent(num);
                queue.add(edge);
            }
        }
        for (int i = 2; i < n + 1; i++) {
            sb.append(nodes[i].parent).append("\n");
        }
        System.out.println(sb);
    }

    public static class Node {
        private int parent = -1;
        private int number = -1;
        private List<Integer> edgeList = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }

        public int getParent() {
            return parent;
        }

        public List<Integer> getEdgeList() {
            return edgeList;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        public void addEdge(int num) {
            edgeList.add(num);
        }
    }
}
