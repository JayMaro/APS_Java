package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class _01_No_10828 {

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
        } else if (command.startsWith("top")) {
            bw.write(top() + "\n");
        }

    }

    private static void push(int number) {
        queue.push(number);
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

    private static int top() {
        try {
            return queue.getFirst();
        } catch (Exception e) {
            return -1;
        }
    }
}

/*
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
