package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class No_16948 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] moveArray = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
    static int maxMoveCount = 2000000000;

    public static void main(String[] args) throws IOException {
        int boardSize = Integer.parseInt(br.readLine());
        int[][] chessBoard = new int[boardSize][boardSize];
        int[][] visited = new int[boardSize][boardSize];

        String[] input = br.readLine().split(" ");
        List<Integer> position = Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList());
        int r1 = position.get(0);
        int c1 = position.get(1);
        int r2 = position.get(2);
        int c2 = position.get(3);

        chessBoard[r1][c1] = 1;
        chessBoard[r2][c2] = 2;

        // 0: r, 1: c, 2: count
        LinkedList<int[]> positionAndCount = new LinkedList<>();
        positionAndCount.addLast(new int[]{r1, c1, 0});
        visited[r1][c1] = 1;
        while (positionAndCount.size() != 0) {

            int[] findPosition = positionAndCount.removeFirst();
            for (int[] movePosition : moveArray) {
                int newR = findPosition[0] + movePosition[0];
                int newC = findPosition[1] + movePosition[1];
                if (newR >= boardSize || newC >= boardSize || newC < 0 || newR < 0 || visited[newR][newC] == 1) {
                    continue;
                } else if (chessBoard[newR][newC] == 2) {
                    maxMoveCount = findPosition[2] + 1;
                    positionAndCount.clear();
                    break;
                } else {
                    positionAndCount.addLast(new int[]{newR, newC, findPosition[2] + 1});
                    visited[newR][newC] = 1;
                }
            }
        }
        if (maxMoveCount == 2000000000) {
            maxMoveCount = -1;
        }
        System.out.println(maxMoveCount);
    }
}
