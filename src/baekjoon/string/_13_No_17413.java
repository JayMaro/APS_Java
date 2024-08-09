package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13_No_17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        for (String input : inputs) {
            StringBuilder sb = new StringBuilder();
            for (char c : input.toCharArray()) {
                if (c == '<') {
                    res.append(sb.reverse());
                    sb = new StringBuilder();
                }
                sb.append(c);
                if (c == '>') {
                    res.append(sb);
                    sb = new StringBuilder();
                }
            }
            res.append(sb.reverse());
            res.append(" ");
        }
        System.out.println(res);
    }

    private static String flip(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
