package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class _03_No_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> valueList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        valueList.sort(Comparator.comparingInt(a -> a));
        StringBuilder sb = new StringBuilder();
        int al = 0;
        int ac = 0;
        int result = 2000000000;
        int resFirst = 0;
        int resSecond = 0;
        if (valueList.get(n - 1) < 0) {
            resFirst = valueList.get(n - 2);
            resSecond = valueList.get(n - 1);
        } else if (valueList.get(0) > 0) {
            resFirst = valueList.get(0);
            resSecond = valueList.get(1);
        } else {
            ac = n-1;
            al = 0;
            while (ac > al && al < n && ac >= 0) {
                int acid = valueList.get(ac);
                int alcali = valueList.get(al);
                int abs = Math.abs(acid + alcali);
                if (abs < result) {
                    result = abs;
                    resFirst = alcali;
                    resSecond = acid;
                    if (abs == 0) {
                        break;
                    }
                } else {
                    if (acid + alcali < 0) {
                        al += 1;
                    } else {
                        ac -= 1;
                    }
                }
            }
        }
        if (resFirst > resSecond) {
            sb.append(resSecond).append(" ").append(resFirst);
        } else {
            sb.append(resFirst).append(" ").append(resSecond);
        }
        System.out.println(sb);
    }
}
