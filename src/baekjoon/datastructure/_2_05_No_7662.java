package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class _2_05_No_7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> map = new TreeMap<>((a,b) -> b - a);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                String[] s = br.readLine().split(" ");
                if ("I".equals(s[0])) {
                    int val = Integer.parseInt(s[1]);
                    map.put(val, val);
                } else if ("1".equals(s[1])) {
                    if (map.isEmpty()) {
                        continue;
                    }
                    Integer maxVal = map.firstKey();
                    map.remove(maxVal);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }
                    Integer minVal = map.lastKey();
                    map.remove(minVal);
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.firstKey()).append(" ").append(map.lastKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
