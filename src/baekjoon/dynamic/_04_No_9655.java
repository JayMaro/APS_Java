package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _04_No_9655 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        if (N % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
        /*
        N = 1 SK
        N = 2 CY
        N = 3 SK
        N = 4 CY
        S(1) + S(3)
        N = 5 SK
        N = 6 CY
         */

    }
}
