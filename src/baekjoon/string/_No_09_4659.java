package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _No_09_4659 {
    // a e i o u 하나를 포함
    // 모음이 3개 or 자음이 3개 연속 x
    // 같은 글자가 연속 두번은 안되나 ee와 oo는 허용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if ("end".equals(input)) {
                break;
            }

            boolean isContainVowel = false;
            int beforeCharCount = 0;
            int vowelCount = 0;
            int consonantCount = 0;
            char beforeChar = ' ';
            boolean isAvailable = true;
            char[] chars = input.toCharArray();

            for (char c : chars) {
                // 모음이 3개 or 자음이 3개 연속 x
                if (checkIsVowel(c)) {
                    isContainVowel = true; // a e i o u 하나를 포함
                    vowelCount++;
                    consonantCount = 0;
                    if (vowelCount >= 3) {
                        isAvailable = false;
                        break;
                    }
                } else {
                    consonantCount++;
                    vowelCount = 0;
                    if (consonantCount >= 3) {
                        isAvailable = false;
                        break;
                    }
                }
                // 같은 글자가 연속 두번은 안되나 ee와 oo는 허용
                if (c == beforeChar) {
                    beforeCharCount++;
                    if (beforeCharCount >= 2 && (beforeChar != 'e' && beforeChar != 'o')) {
                        isAvailable = false;
                        break;
                    }
                } else {
                    beforeChar = c;
                    beforeCharCount = 1;
                }
            }
            sb.append("<").append(input).append(">").append(" is ")
                .append(isContainVowel && isAvailable ? "acceptable." : "not acceptable.").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean checkIsVowel(char c) {
        char[] vowels = new char[]{'a', 'e', 'o', 'u', 'i'};
        for (char vowel : vowels) {
            if (vowel == c) {
                return true;
            }
        }
        return false;
    }
}
