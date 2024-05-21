package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _01_No_21921 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int X = Integer.parseInt(inputs[1]);
        List<Integer> valList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int head = 0;
        int tail = X;
        int maxVal = 0;
        int count = 0;
        int nowSum = 0;
        for (int i = 0; i < X; i++) {
            nowSum += valList.get(i);
        }
        while (true) {
            if (nowSum > maxVal) {
                maxVal = nowSum;
                count = 1;
            } else if (nowSum == maxVal) {
                count += 1;
            }

            if (tail >= N) {
                break;
            }
            nowSum -= valList.get(head++);
            nowSum += valList.get(tail++);
        }
        if (maxVal == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVal);
            System.out.println(count);
        }
    }

}
