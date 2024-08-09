package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13_No_17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        boolean isTag = false;
        for (char c : input.toCharArray()) {
            if (c == '<') {
                isTag = true;
                res.append(sb.reverse());
                sb = new StringBuilder().append(c);
            } else if (c == '>') {
                isTag = false;
                res.append(sb.append(c));
                sb = new StringBuilder();
            } else if (!isTag && c == ' ') {
                res.append(sb.reverse()).append(c);
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        res.append(sb.reverse());
        System.out.println(res);
    }
}
