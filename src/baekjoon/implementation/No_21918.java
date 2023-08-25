package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_21918 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] NM = br.readLine().split(" ");
        // 전구 갯수
        int N = Integer.parseInt(NM[0]);
        // 명령어 갯수
        int M = Integer.parseInt(NM[1]);
        Integer[] bulbs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        for (int i = 0; i < M; i++) {
            Integer[] orders = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            if (orders[0] == 1) {
                func1(bulbs, orders[1], orders[2]);
            } else if (orders[0] == 2) {
                func2(bulbs, orders[1], orders[2]);
            } else if (orders[0] == 3) {
                func3(bulbs, orders[1], orders[2]);
            } else {
                func4(bulbs, orders[1], orders[2]);
            }
        }
        for (Integer i : bulbs) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void func1(Integer[] bulbs, int i, int x) {
        bulbs[i-1] = x;
    }

    public static void func2(Integer[] bulbs, int l, int r) {
        for (int i = l-1; i <= r-1; i++) {
            if (bulbs[i] == 0) {
                bulbs[i] = 1;
            } else {
                bulbs[i] = 0;
            }
        }
    }

    public static void func3(Integer[] bulbs, int l, int r) {
        for (int i = l-1; i <= r-1; i++) {
            bulbs[i] = 0;
        }
    }

    public static void func4(Integer[] bulbs, int l, int r) {
        for (int i = l-1; i <= r-1; i++) {
            bulbs[i] = 1;
        }
    }
}
