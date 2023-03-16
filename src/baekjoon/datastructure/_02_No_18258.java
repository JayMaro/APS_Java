package baekjoon.datastructure;

import java.io.*;
import java.util.*;

public class _02_No_18258 {
    static private LinkedList<Integer> queue = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        try {
            int commandNum= Integer.parseInt(br.readLine());
            for (int i = 0; i < commandNum; i++) {
                execute(br.readLine());
            }
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void execute(String command) throws IOException {
        if (command.startsWith("push")) {
            String[] commands = command.split(" ");
            int num = Integer.parseInt(commands[1]);
            push(num);
        } else if (command.startsWith("pop")) {
            bw.write(pop() + "\n");
        } else if (command.startsWith("size")) {
            bw.write(size() + "\n");
        } else if (command.startsWith("empty")) {
            bw.write(empty() + "\n");
        } else if (command.startsWith("front")) {
            bw.write(front() + "\n");
        } else if (command.startsWith("back")) {
            bw.write(back() + "\n");
        }


    }

    private static void push(int number) {
        queue.add(number);
    }

    private static int pop() {
        try {
            return queue.pop();
        } catch (Exception e) {
            return -1;
        }
    }

    private static int size() {
        return queue.size();
    }

    private static int empty() {
        if (queue.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int front() {
        try {
            return queue.getFirst();
        } catch (Exception e) {
            return -1;
        }
    }

    private static int back() {
        try {
            return queue.getLast();
        } catch (Exception e) {
            return -1;
        }
    }
}

/*
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */