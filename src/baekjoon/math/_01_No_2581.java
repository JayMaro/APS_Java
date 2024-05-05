package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _01_No_2581 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] isNotPrimeArr = new int[10001];
        List<Integer> primeList = new ArrayList<>();
        primeList.add(2);
        primeList.add(3);

        for (int i = 5; i <= 100; i += 2) {
            boolean isPrime = true;
            for (int num : primeList) {
                if (i % num == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeList.add(i);
            }
        }
        isNotPrimeArr[0] = 1;
        isNotPrimeArr[1] = 1;
        for (int prime : primeList) {
            int count = 2;
            while (true) {
                if ((prime * count) > 10000) {
                    break;
                }
                isNotPrimeArr[prime * count] = 1;
                count++;
            }
        }

        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());

        int sum = 0;
        int minPrimeNum = 0;
        for (int i = first; i <= second; i++) {
            if (isNotPrimeArr[i] == 0) {
                if (minPrimeNum == 0) {
                    minPrimeNum = i;
                }
                sum += i;
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(minPrimeNum);
        }
    }
}
