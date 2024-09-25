package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class _2_05_No_7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>((a,b) -> b - a);
            for (int j = 0; j < k; j++) {
                String[] s = br.readLine().split(" ");
                if ("I".equals(s[0])) {
                    int val = Integer.parseInt(s[1]);
                    map.put(val, map.getOrDefault(val, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }
                    Integer val;
                    if ("1".equals(s[1])) {
                        val = map.firstKey();
                    } else {
                        val = map.lastKey();
                    }
                    Integer count = map.getOrDefault(val, 0);
                    if (count == 1) {
                        map.remove(val);
                    } else if (count != 0) {
                        map.put(val, count - 1);
                    }
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
