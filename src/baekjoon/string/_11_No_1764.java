package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _11_No_1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        Map<String, Integer> nameMap = new HashMap<>();
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            nameMap.put(input, 1);
        }
        for (int j = 0; j < M; j++) {
            String input = br.readLine();
            Integer value = nameMap.getOrDefault(input, 0);
            if (value == 1) {
                resultList.add(input);
            }
        }
        resultList.sort(String::compareTo);
        sb.append(resultList.size()).append("\n");
        for (String s : resultList) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
