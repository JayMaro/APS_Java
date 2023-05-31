package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class No_1010 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int row = Integer.parseInt(br.readLine());
        for (int i = 0; i < row; i++) {
            String[] inputStr = br.readLine().split(" ");
            int N = Integer.parseInt(inputStr[0]);
            int M = Integer.parseInt(inputStr[1]);

            // 조합
            List<Integer> numbers = new ArrayList<>();
            List<Integer> divideNumbers = new ArrayList<>();
            for (int j = M; j > M-N; j--) {
                numbers.add(j);
            }
            for (int j = N; j > 1; j--) {
                if (numbers.contains(j)) {
                    numbers.remove(new Integer(j));
                } else {
                    divideNumbers.add(j);
                }
            }
            long result = 1;
            for (Integer number : numbers) {
                result *= number;
            }
            for (Integer divideNumber : divideNumbers) {
                result /= divideNumber;
            }

            bw.write(String.valueOf(result));
            bw.write("\n");
            bw.flush();
        }

    }

}
