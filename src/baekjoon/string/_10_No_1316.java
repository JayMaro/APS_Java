package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _10_No_1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            char[] inputChars = br.readLine().toCharArray();
            char before = ' ';
            boolean isGroupWord = true;
            HashSet<Character> hashSet = new HashSet<>();
            for (char inputChar : inputChars) {
                if (inputChar != before) {
                    if (hashSet.contains(inputChar)) {
                        isGroupWord = false;
                        break;
                    } else {
                        hashSet.add(inputChar);
                    }
                }
                before = inputChar;
            }
            if (isGroupWord) {
                count++;
            }
        }
        System.out.println(count);
    }
}
