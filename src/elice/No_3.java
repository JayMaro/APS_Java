package elice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class No_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> queue = new ArrayDeque<>();

        String s = br.readLine();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String str = queue.removeLast();
                    if ("(".equals(str)) {
                        break;
                    }
                    sb.append(str);
                }
                String str = queue.removeLast();
                queue.addLast(sb.toString().repeat(Integer.parseInt(str)));
            } else {
                queue.addLast(String.valueOf(chars[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : queue) {
            sb.append(str);
        }
        System.out.println(sb.length());
    }
}
