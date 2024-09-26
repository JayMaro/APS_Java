package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class _06_No_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int moveCount = 0;
        int n = Integer.parseInt(br.readLine());
        List<Integer> moveList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        list.removeFirst();
        resultList.add(0);
        moveCount = moveList.get(0);
        while (!list.isEmpty()) {
            if (moveCount > 0) {
                moveCount -= 1;
            }
            while (moveCount != 0) {
                if (moveCount > 0) {
                    list.addLast(list.removeFirst());
                    moveCount -= 1;
                } else {
                    list.addFirst(list.removeLast());
                    moveCount += 1;
                }
            }
            Integer num = list.removeFirst();
            moveCount = moveList.get(num);
            resultList.add(num);
        }
        for (Integer num : resultList) {
            sb.append(num+1).append(" ");
        }
        System.out.println(sb);
    }
}
