package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_14916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int money = Integer.parseInt(br.readLine());
        int numberOf5 = money / 5;
        int numberOf2 = 0;

        while (numberOf5 >= 0) {
            int rest = money - (numberOf5 * 5);
            if (rest % 2 == 0) {
                numberOf2 = rest / 2;
                break;
            } else {
                numberOf5--;
            }
        }
        System.out.println(numberOf2 + numberOf5);
    }
}
