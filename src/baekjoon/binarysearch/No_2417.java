package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2417 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long number = Long.parseLong(br.readLine());
        double ans = Math.floor(Math.ceil(Math.sqrt(number)));
        System.out.printf("%.0f", ans);
    }
}
