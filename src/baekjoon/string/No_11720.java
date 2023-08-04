package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11720 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        char[] chars = input.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += c-48;
        }
        System.out.println(sum);
    }
}
