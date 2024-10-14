package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _09_No_1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 스위치 수 1 ~ 100
        String[] temp = br.readLine().split(" "); // 스위치 상태
        String[] switchArr = new String[temp.length+1];
        System.arraycopy(temp, 0, switchArr, 1, temp.length);
        int s = Integer.parseInt(br.readLine()); // 학생수 1 ~ 100
        // 남 자신이 받은 숫자의 배수 스위치의 상태를 변경
        // 여 자신이 받은 숫자를 중심으로 대칭인 스위치를 모두 변경한다 -> 1 3 5
        // 성별 받은 수 1 남자 2 여자
        for (int i = 0; i < s; i++) {
            String[] input = br.readLine().split(" ");
            int number = Integer.parseInt(input[1]);
            if ("1".equals(input[0])) {
                for (int j = number; j < switchArr.length; j += number) {
                    switchArr[j] = flip(switchArr[j]);
                }
            } else {
                int start = number;
                int end = number;
                while (start > 0 && end < switchArr.length) {
                    if (switchArr[start].equals(switchArr[end])) {
                        start--;
                        end++;
                    } else {
                        start++;
                        end--;
                        break;
                    }
                }
                if (start == 0 || end == switchArr.length) {
                    start++;
                    end--;
                }
                for (int j = start; j <= end; j++) {
                    switchArr[j] = flip(switchArr[j]);
                }
            }
        }
        for (int i = 1; i < switchArr.length; i++) {
            sb.append(switchArr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static String flip(String s) {
        if ("0".equals(s)) {
            return "1";
        } else if ("1".equals(s)) {
            return "0";
        } else {
            return null;
        }
    }
}
