package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class _03_No_1158 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] command = br.readLine().split(" ");
        int count = Integer.parseInt(command[0]);
        int term = Integer.parseInt(command[1]);

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            list.add(i+1);
        }
        int termCount = 0;
        List<Integer> result = new ArrayList<>();
        while (!list.isEmpty()) {
            termCount = (termCount + 1) % term;
            Integer first = list.poll();
            if (termCount == 0) {
                result.add(first);
            } else {
                list.add(first);
            }
        }
        String resultStr = result.toString().replace('[', '<').replace(']', '>');
        bw.write(resultStr);
        bw.flush();
        bw.close();

    }
}
