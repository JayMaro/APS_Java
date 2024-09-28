package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _07_No_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            ArrayDeque<Doc> docArrayDeque = new ArrayDeque<>();
            String[] s = br.readLine().split(" ");
            int number = Integer.parseInt(s[0]);
            int purposeIndex = Integer.parseInt(s[1]);
            int orderNum = 0;
            String[] priorityArray = br.readLine().split(" ");
            for (int j = 0; j < number; j++) {
                int priority = Integer.parseInt(priorityArray[j]);
                docArrayDeque.addLast(new Doc(priority, purposeIndex == j));
                priorityQueue.add(priority);
            }
            Integer priority = priorityQueue.poll();
            while (true) {
                Doc doc = docArrayDeque.removeFirst();
                if (doc.getPriority() == priority) {
                    orderNum++;
                    if (doc.isPurpose()) {
                        break;
                    }
                    priority = priorityQueue.poll();
                } else {
                    docArrayDeque.addLast(doc);
                }
            }
            sb.append(orderNum).append("\n");
        }
        System.out.println(sb);
    }

    public static class Doc{
        private int priority;
        private boolean isPurpose;

        public Doc(int priority, boolean isPurpose) {
            this.priority = priority;
            this.isPurpose = isPurpose;
        }

        public int getPriority() {
            return priority;
        }

        public boolean isPurpose() {
            return isPurpose;
        }
    }
}
