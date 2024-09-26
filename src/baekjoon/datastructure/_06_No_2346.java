package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class _06_No_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Balloon> list = new LinkedList<>();
        int moveCount = 0;
        int n = Integer.parseInt(br.readLine());
        List<Integer> moveList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 0; i < n; i++) {
            list.add(new Balloon(i + 1, moveList.get(i)));
        }
        Balloon balloon1 = list.removeFirst();
        moveCount = balloon1.getMove();
        while (moveCount != 0) {
            if (moveCount > 0) {
                Balloon balloon = list.removeFirst();
                list.addLast(balloon);
                moveCount -= 1;
            } else {
                Balloon balloon = list.removeLast();
                list.addFirst(balloon);
                moveCount += 1;
            }
        }



    }

    public static class Balloon {
        private int num;
        private int move;

        public Balloon(int num, int move) {
            this.num = num;
            this.move = move;
        }

        public int getNum() {
            return this.num;
        }

        public int getMove() {
            return this.move;
        }
    }
}
