package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _00_No_20436 {

    public static char[][] keyboard = new char[3][];
    public static int[] nowLeft;
    public static int[] nowRight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        keyboard[0] = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        keyboard[1] = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        keyboard[2] = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        int result = 0;
        char[] inputKeys = br.readLine().toCharArray();
        char leftChar = inputKeys[0];
        char rightChar = inputKeys[2];
        nowLeft = findPosition(leftChar);
        nowRight = findPosition(rightChar);
        char[] chars = br.readLine().toCharArray();

        // 4보다 작으면 왼손, 4보다 크면 오른손, 4이고 2이면 오른손 나머지 왼손
        for (char c : chars) {
            int[] position = findPosition(c);
            if (position[1] > 4 || (position[1] == 4 && position[0] == 2)) {
                result += findTime(nowRight, position);
                result ++;
                nowRight = position;
            } else {
                result += findTime(nowLeft, position);
                result ++;
                nowLeft = position;
            }
        }
        System.out.println(result);
    }

    public static int[] findPosition(char c) {
        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < keyboard[i].length; j++) {
                if (keyboard[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    public static int findTime(int[] start, int[] target) {
        return Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1]);
    }
}
