package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _03_No_9046 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int max = 0;
            char res = '?';
            char[] input = br.readLine().toCharArray();
            Map<Character, Integer> countMap = new HashMap<>();
            for (char c : input) {
                if (c == ' ') {
                    continue;
                }
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }
            for (char c : countMap.keySet()) {
                if (countMap.get(c) > max) {
                    res = c;
                    max = countMap.get(c);
                } else if (countMap.get(c) == max) {
                    res = '?';
                }
            }
            System.out.println(res);
        }
    }

}
