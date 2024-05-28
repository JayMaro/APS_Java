package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2417 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long number = Long.parseLong(br.readLine());
        long left = 0;
        long right = number;
        long mid = number/2;
        long result = 0;

        while (right >= left) {
            if (Math.pow(mid, 2) >= number) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = ((right + left) / 2);
        }
        System.out.println(result);
    }
}
