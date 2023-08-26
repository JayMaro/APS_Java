package baekjoon.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No_22864 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String inputString = br.readLine();
        String[] splitStrings = inputString.split(" ");
        // 시간당 축적 피로도
        int A = Integer.parseInt(splitStrings[0]);
        // 시간당 일처리
        int B = Integer.parseInt(splitStrings[1]);
        // 시간당 회복 피로도
        int C = Integer.parseInt(splitStrings[2]);
        // 피로도 제한
        int M = Integer.parseInt(splitStrings[3]);

        // 24시간 최대한으로 할 수 있는 일
        // 일한 시간 * A - 쉬는 시간 * C < M
        // A + C = 24

    }
}
