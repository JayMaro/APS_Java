package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _2_01_No_14425 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int res = 0;
        Map<String, Integer> resMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            resMap.put(br.readLine(), 1);
        }
        for (int j = 0; j < M; j++) {
            Integer val = resMap.getOrDefault(br.readLine(), 0);
            if (val == 1) {
                res++;
            }
        }
        System.out.println(res);
    }
}
