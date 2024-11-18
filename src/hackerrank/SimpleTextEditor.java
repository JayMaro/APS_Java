package hackerrank;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class SimpleTextEditor {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        LinkedList<StringBuilder> logSb = new LinkedList<>();
        for (int i = 0; i < t; i++) {
            String[] inputs = br.readLine().split(" ");
            String op = inputs[0];
            if (op.equals("1")) {
                logSb.addFirst(new StringBuilder(sb));
                sb.append(inputs[1]);
            } else if (op.equals("2")) {
                logSb.addFirst(new StringBuilder(sb));
                sb.delete(sb.length() - Integer.parseInt(inputs[1]), sb.length());
            } else if (op.equals("3")) {
                System.out.println(sb.charAt(Integer.parseInt(inputs[1]) - 1));
            } else {
                sb = logSb.pollFirst();
            }
        }
    }
}

