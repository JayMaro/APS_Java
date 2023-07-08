package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class No_21608 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 자리 초기화
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> seatList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                tempList.add(-1);
            }
            seatList.add(tempList);
        }
        // 좋아하는 학생 초기화
        List<List<Integer>> likeStudentList = new ArrayList<>();
        LinkedList<Integer> inputStudentList = new LinkedList<>();
        for (int i = 0; i < N * N; i++) {
            likeStudentList.add(new ArrayList<>());
        }
        for (int i = 0; i < N * N; i++) {
            String[] input = br.readLine().split(" ");
            List<Integer> integers = Arrays.stream(input).map(Integer::parseInt).map((item) -> (item-1)).collect(Collectors.toList());
            Integer student = integers.remove(0);
            inputStudentList.addLast(student);
            likeStudentList.get(student).addAll(integers);
        }
        // 인접한 학생의 수와 비어있는 칸을 구하는 메서드 생성 -> 만약 이전의 값보다 크다면 해당 좌표를 저장
        int[][] moveArray = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!inputStudentList.isEmpty()) {
            Integer targetStudent = inputStudentList.removeFirst();
            int maxNearLike = 0;
            int maxBlank = 0;
            int targetX = -1;
            int targetY = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int nearLike = 0;
                    int blank = 0;
                    if (seatList.get(i).get(j) != -1) {
                        continue;
                    }
                    for (int k = 0; k < 4; k++) {
                        int xMove = moveArray[k][0];
                        int yMove = moveArray[k][1];
                        int x = i + xMove;
                        int y = j + yMove;
                        if (x >= 0 && x < N && y >= 0 && y < N) {
                            int findStudent = seatList.get(x).get(y);
                            if (findStudent == -1) {
                                blank++;
                            } else {
                                if (likeStudentList.get(targetStudent).contains(findStudent)) {
                                    nearLike++;
                                }
                            }
                        }
                    }
                    if (nearLike > maxNearLike) {
                        maxNearLike = nearLike;
                        maxBlank = blank;
                        targetX = i;
                        targetY = j;
                    } else if (nearLike == maxNearLike && blank > maxBlank) {
                        maxBlank = blank;
                        targetX = i;
                        targetY = j;
                    } else if (targetX == -1) {
                        targetX = i;
                        targetY = j;
                    }
                }
            }
            seatList.get(targetX).set(targetY, targetStudent);
        }
        int maxHappy = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int maxNearLike = 0;
                int targetStudent = seatList.get(i).get(j);
                for (int k = 0; k < 4; k++) {
                    int xMove = moveArray[k][0];
                    int yMove = moveArray[k][1];
                    int x = i + xMove;
                    int y = j + yMove;
                    if (x >= 0 && x < N && y >= 0 && y < N) {
                        int findStudent = seatList.get(x).get(y);
                        if (likeStudentList.get(targetStudent).contains(findStudent)) {
                            maxNearLike++;
                        }
                    }
                }
                switch (maxNearLike) {
                    case 0:
                        break;
                    case 1:
                        maxHappy += 1;
                        break;
                    case 2:
                        maxHappy += 10;
                        break;
                    case 3:
                        maxHappy += 100;
                        break;
                    case 4:
                        maxHappy += 1000;
                }
            }
        }
        System.out.println(maxHappy);
    }
}
