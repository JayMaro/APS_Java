package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1789 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        long S = Long.parseLong(br.readLine());
        long sum = 0;
        long targetNum = 1;
        while (true) {
            sum += targetNum;
            if (sum > S) {
                break;
            }
            targetNum++;
        }
        targetNum--;
        System.out.println(sb.append(targetNum));
    }
}
