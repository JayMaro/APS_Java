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
        List<Character> characters = new ArrayList<>();
        char before = ' ';
        for (int j = 0; j < input.length(); j++) {
            if (inputCharArr[j] != before) {
                characters.add(inputCharArr[j]);
                before = inputCharArr[j];
            }
        }
        if (characters.size() == 3
            && characters.get(0).equals('A')
            && characters.get(1).equals('F')
            && characters.get(2).equals('C')) {
            return true;
        }
        if (characters.size() == 5
            && characters.get(1).equals('A')
            && characters.get(2).equals('F')
            && characters.get(3).equals('C')
            && checkIsContain(characters.get(0))
            && checkIsContain(characters.get(4))) {
            return true;
        }
        if (characters.size() == 4) {
            if (!characters.get(0).equals('A')
                && checkIsContain(characters.get(0))
                && characters.get(1).equals('A')
                && characters.get(2).equals('F')
                && characters.get(3).equals('C')) {
                return true;
            }
            if (characters.get(0).equals('A')
                && characters.get(1).equals('F')
                && characters.get(2).equals('C')
                && checkIsContain(characters.get(3))) {
                return true;
            }
        }

        return false;
    }
}
