package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _06_No_1935 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        LinkedList<Double> stack = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        String expression = br.readLine();
        Map<Character, Double> charMap = new HashMap<>();
        char A = 'A';

        for (int i=0; i<N; i++) {
            double val = Double.parseDouble(br.readLine());
            charMap.put((char)(A+i), val);
        }

        for (char ex:expression.toCharArray()) {
            if (ex >= 65 && ex <= 90) {
                stack.add(charMap.get(ex));
            } else if (ex == '*') {
                double first = stack.removeLast();
                double second = stack.removeLast();
                stack.add(second * first);
            } else if (ex == '/') {
                double first = stack.removeLast();
                double second = stack.removeLast();
                stack.add(second / first);
            } else if (ex == '+') {
                double first = stack.removeLast();
                double second = stack.removeLast();
                stack.add(second + first);
            } else if (ex == '-') {
                double first = stack.removeLast();
                double second = stack.removeLast();
                stack.add(second - first);
            }
        }
        double result = stack.removeLast();
        System.out.printf("%.2f", result);
    }
}
