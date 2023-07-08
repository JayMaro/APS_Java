package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1343 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] Xs = input.split("\\.");
        if (Xs.length == 0 && input.contains("X")) {
            Xs = new String[]{input};
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder resultBuilder = new StringBuilder();
        boolean isNotValid = false;
        for (String X : Xs) {
            int xLen = X.length();
            if (xLen % 2 != 0) {
                isNotValid = true;
                break;
            } else {
                for (int i = 0; i < (xLen / 4); i++) {
                    sb.append("AAAA");
                }
                if (xLen % 4 != 0) {
                    sb.append("BB");
                }
            }
        }
        if (isNotValid) {
            System.out.println(-1);
        } else {
            int sbIndex = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'X') {
                    resultBuilder.append(sb.charAt(sbIndex++));
                } else {
                    resultBuilder.append(".");
                }
            }
            System.out.println(resultBuilder.toString());
        }
    }
}
