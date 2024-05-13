package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _02_No_2217 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int resCount = 0;
        int min = 10000;
        int sum;
        int now;
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numList.add(Integer.parseInt(br.readLine()));
        }
        numList.sort((a,b) -> b - a);
        for (int num : numList) {
            sum = min * resCount;
            now = num * (count+1);
            if (now >= sum) {
                min = num;
                resCount = count+1;
            }
            count++;
        }
        System.out.println(min*resCount);
    }
}
