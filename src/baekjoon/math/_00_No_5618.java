package baekjoon.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _00_No_5618 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int count = Integer.parseInt(br.readLine());
        String[] strNumbers = br.readLine().split(" ");
        int num1 = Integer.parseInt(strNumbers[0]);
        int num2 = Integer.parseInt(strNumbers[1]);
        int num3 = 0;
        if (count == 3) {
            num3 = Integer.parseInt(strNumbers[2]);
        }

        for (int i = 1; i <= num1; i++) {
            if (num1 % i == 0 && num2 % i == 0 && num3 % i == 0) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
