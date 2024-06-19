package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _2_00_No_1620 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Map<String, Integer> stringDictionary = new HashMap<>();
        Map<Integer, String> integerDictionary = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String pocketMon = br.readLine();
            stringDictionary.put(pocketMon, i + 1);
            integerDictionary.put(i + 1, pocketMon);
        }
        for (int i = 0; i < M; i++) {
            String data = br.readLine();
            try {
                int number = Integer.parseInt(data);
                System.out.println(integerDictionary.get(number));
            } catch (NumberFormatException e) {
                System.out.println(stringDictionary.get(data));
            }
        }
    }
}
