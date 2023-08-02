package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class No_5597 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        TreeSet<Integer> numSet = IntStream.range(1, 31).boxed().collect(Collectors.toCollection(TreeSet::new));
        for (int i = 0; i < 28; i++) {
            int number = Integer.parseInt(br.readLine());
            numSet.remove(number);
        }
        numSet.forEach(System.out::println);
    }
}
