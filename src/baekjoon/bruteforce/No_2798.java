package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class No_2798 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Long> collect = Arrays.stream(br.readLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
        Long numberOfCard = collect.get(0);
        Long target = collect.get(1);
        List<Long> numbers = Arrays.stream(br.readLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
        long maxValue = 0;
        long sum = 0;
        for (int i = 0; i < numberOfCard-2; i++) {
            sum += numbers.get(i);
            if (sum > target) {
                sum -= numbers.get(i);
                continue;
            }
            for (int j = i+1; j < numberOfCard-1; j++) {
                sum += numbers.get(j);
                if (sum > target) {
                    sum -= numbers.get(j);
                    continue;
                }
                for (int k = j+1; k < numberOfCard; k++) {
                    sum += numbers.get(k);
                    if (sum <= target && sum > maxValue) {
                        maxValue = sum;
                    }
                    sum -= numbers.get(k);
                }
                sum -= numbers.get(j);
            }
            sum -= numbers.get(i);
        }
        System.out.println(maxValue);
    }
}
