package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _06_No_20154 {

    public static void main(String[] args) throws IOException {
        Map<Character, Integer> alphaMap = new HashMap<>();
        int[] alphaArr = new int[]{3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        for (int i = 0; i < 26; i++) {
            alphaMap.put((char) ('A' + i), alphaArr[i]);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] chars = input.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += alphaMap.get(c);
        }
        System.out.println(sum % 2 == 1 ? "I'm a winner!" : "You're the winner?");

//        LinkedList<Integer> charToInt = new LinkedList<>();
//        for (char c : chars) {
//            charToInt.addLast(alphaMap.get(c));
//        }
//        while (charToInt.size() != 1) {
//            charToInt = cal(charToInt);
//        }
//        System.out.println(charToInt.poll() % 2 == 1 ? "I'm a winner!" : "You're the winner?");
    }

    private static LinkedList<Integer> cal(LinkedList<Integer> charToInt) {
        LinkedList<Integer> res = new LinkedList<>();
        while (!charToInt.isEmpty()) {
            Integer a = charToInt.pollFirst();
            Integer b = charToInt.pollFirst();
            if (a != null && b != null) {
                res.addLast((a + b) % 10);
            } else {
                res.addLast(a);
            }
        }
        return res;
    }
}
