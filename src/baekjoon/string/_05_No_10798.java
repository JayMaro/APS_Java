package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _05_No_10798 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        char[][] charArray = new char[5][15];
        char[] defaultChar = new char[1];
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            char[] chars = input.toCharArray();
            System.arraycopy(chars, 0, charArray[i], 0, input.length());
        }
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (charArray[i][j] != defaultChar[0]) {
                    sb.append(charArray[i][j]);
                }
            }
        }
        System.out.println(sb);
    }

    public static void v2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] inputArr = new char[5][15];
        char defaultChar = inputArr[0][0];
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            char[] inputToCharArr = input.toCharArray();
            System.arraycopy(inputToCharArr, 0, inputArr[i], 0, inputToCharArr.length);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (defaultChar == inputArr[j][i]) {
                    continue;
                }
                sb.append(inputArr[j][i]);
            }
        }
        System.out.println(sb);
    }
}
