package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2578 {

    public static String[][] myBoard = new String[5][5];
    public static String[][] orderBoard = new String[5][5];
    public static boolean[][] answerBoard = new boolean[5][5];
    public static int orderCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isEnd = false;
        for (int i = 0; i < 5; i++) {
            myBoard[i] = br.readLine().split(" ");
        }
        for (int i = 0; i < 5; i++) {
            orderBoard[i] = br.readLine().split(" ");
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                orderCount++;
                checkNumber(orderBoard[i][j]);
                if (checkBingoCount() >= 3) {
                    isEnd = true;
                    break;
                }
            }
            if (isEnd) {
                break;
            }
        }
        System.out.println(orderCount);
    }

    public static void checkNumber(String number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (number.equals(myBoard[i][j])) {
                    answerBoard[i][j] = true;
                }
            }
        }
    }

    public static int checkBingoCount() {
        int bingoCount = 0;
        for (int i = 0; i < 5; i++) {
            boolean rowBingo = true;
            for (int j = 0; j < 5; j++) {
                if (!answerBoard[i][j]) {
                    rowBingo = false;
                    break;
                }
            }
            if (rowBingo) {
                bingoCount++;
            }
        }
        for (int j = 0; j < 5; j++) {
            boolean colBingo = true;
            for (int i = 0; i < 5; i++) {
                if (!answerBoard[i][j]) {
                    colBingo = false;
                    break;
                }
            }
            if (colBingo) {
                bingoCount++;
            }
        }
        boolean crossBingo = true;
        boolean reverseCrossBingo = true;
        for (int i = 0; i < 5; i++) {
            if (!answerBoard[i][i]) {
                crossBingo = false;
            }
            if (!answerBoard[4-i][i]) {
                reverseCrossBingo = false;
            }
        }
        if (crossBingo) {
            bingoCount++;
        }
        if (reverseCrossBingo) {
            bingoCount++;
        }
        return bingoCount;
    }
}
