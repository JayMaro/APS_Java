package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class _04_No_2164 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int number = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= number; i++) {
            list.add(i);
        }
        Integer result = 0;
        while (list.size() >= 1) {
            result = list.poll();
            try {
                int returnNumber = list.poll();
                list.add(returnNumber);
            } catch (Exception e) {

            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
