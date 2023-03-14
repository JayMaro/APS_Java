package baekjoon.datastructure;

import java.io.*;
import java.util.*;

public class _00_No_9012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedList<Character> stack = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            stack.clear();
            if (vps(br.readLine())) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static boolean vps(String text) {
        char[] chars = text.toCharArray();
        try {
            for (char chr : chars) {
                if (chr == '(') {
                    stack.push(chr);
                } else {
                    stack.pop();
                }
            }
        } catch (Exception e) {
            return false;
        }
        return 0 == stack.size();
    }
}
