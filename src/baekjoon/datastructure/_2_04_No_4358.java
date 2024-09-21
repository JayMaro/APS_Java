package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class _2_04_No_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> resultMap = new TreeMap<>();
        int totalCount = 0;
        String input = " ";
        while ((input = br.readLine()) != null && input.length() != 0) {
            Integer count = resultMap.getOrDefault(input, 0);
            resultMap.put(input, count+1);
            totalCount++;
        }
        Set<Entry<String, Integer>> entries = resultMap.entrySet();
        int finalTotalCount = totalCount;
        entries.forEach((entry) -> {
            sb.append(entry.getKey())
                .append(" ")
                .append(String.format("%.4f", (double)entry.getValue() / (double)finalTotalCount * 100.0d))
                .append("\n");
        });
        System.out.println(sb);
    }
}
