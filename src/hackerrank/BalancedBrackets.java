package hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


public class BalancedBrackets {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static class Result {

        public static String isBalanced(String s) {
            ArrayList<Character> stack = new ArrayList<>();
            Map<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
            char[] inputChars = s.toCharArray();
            for (char c : inputChars) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.add(c);
                } else {
                    if (stack.size() == 0) {
                        return "NO";
                    }
                    char front = stack.remove(stack.size() - 1);
                    char behind = map.get(front);
                    if (behind != c) {
                        return "NO";
                    }
                }
            }
            if (stack.size() != 0) {
                return "NO";
            }
            return "YES";
        }

    }
}
