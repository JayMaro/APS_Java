package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _07_No_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            PriorityQueue<Doc> docPriorityQueue = new PriorityQueue<>(Doc::compareTo);
            String[] s = br.readLine().split(" ");
            int number = Integer.parseInt(s[0]);
            int purposeIndex = Integer.parseInt(s[1]);
            int orderNum = 0;
            String[] priorityArray = br.readLine().split(" ");
            for (int j = 0; j < number; j++) {
                docPriorityQueue.add(new Doc(j, Integer.parseInt(priorityArray[j]), purposeIndex == j));
            }
            while (true) {
                Doc doc = docPriorityQueue.poll();
                orderNum++;
                if (doc.isPurpose) {
                    break;
                }
            }
            sb.append(orderNum).append("\n");
        }
        System.out.println(sb);
    }

    public static class Doc implements Comparable{
        private int index;
        private int priority;
        private boolean isPurpose;

        public Doc(int index, int priority, boolean isPurpose) {
            this.index = index;
            this.priority = priority;
            this.isPurpose = isPurpose;
        }

        public int getIndex() {
            return index;
        }

        public int getPriority() {
            return priority;
        }

        public boolean isPurpose() {
            return isPurpose;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Doc) {
                return ((Doc) o).getPriority() - this.getPriority();
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
