package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No_1697 {

    static int result = 999999;
    static int[] visited = new int[100001];
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        search2(N, M);
        System.out.println(count);
    }

    public static void search2(int N, int M) {
        visited[N] = 1;
        LinkedList<Integer> valueList = new LinkedList<>();
        LinkedList<Integer> countList = new LinkedList<>();
        valueList.add(N);
        countList.add(0);

        while (!valueList.isEmpty()) {
            int now = valueList.pop();
            int nowCount = countList.pop();
            for (int i = 1; i <= 3; i++) {
                int temp;
                if (i == 1) {
                    temp = now + 1;
                } else if (i == 2) {
                    temp = now - 1;
                } else {
                    temp = now * 2;
                }
                if (temp <= 100000 && temp >= 0 && visited[temp] != 1) {
                    if (temp == M) {
                        count =  nowCount + 1;
                    }
                    valueList.add(temp);
                    countList.add(nowCount + 1);
                    visited[temp] = 1;
                }
            }
        }
    }

    // 처음 작성항 재귀 함수
    public static void search(int N, int M) {
        if (N > 100000 || N < 0 || visited[N] == 1 || count >= result) {
            return;
        }
        if (N == M && result > count) {
            result = count;
            return;
        }
        visited[N] = 1;

        for (int i = 1; i <= 3; i++) {
            count += 1;
            switch (i) {
                case 1:
                    search(N+1, M);
                    break;
                case 2:
                    search(N-1, M);
                    break;
                case 3:
                    search(N*2, M);
                    break;
            }
            count -= 1;
        }
        visited[N] = 0;
    }
}
