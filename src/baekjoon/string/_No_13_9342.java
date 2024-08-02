package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _No_13_9342 {

    public static char[] cArr = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            sb.append(checkIsInfected(input) ? "Infected!\n" : "Good\n");
        }
        System.out.println(sb);
    }

    private static boolean checkIsContain(char inputChar) {
        for (char c : cArr) {
            if (inputChar == c) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIsInfected(String input) {
        char[] inputCharArr = input.toCharArray();
        if (!checkIsContain(inputCharArr[0]) || !checkIsContain(inputCharArr[input.length() - 1])) {
            return false;
        }
        List<Character> characters = new ArrayList<>();
        char before = ' ';
        for (int j = 1; j < input.length() - 1; j++) {
            if (inputCharArr[j] != before) {
                characters.add(inputCharArr[j]);
                before = inputCharArr[j];
            }
        }
        return characters.size() == 3
            && characters.get(0).equals('A')
            && characters.get(1).equals('F')
            && characters.get(2).equals('C');
    }
}
