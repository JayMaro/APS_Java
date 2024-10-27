package hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlippingTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result.flippingMatrix(matrix, n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static class Result {

        /*
         * Complete the 'flippingMatrix' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
         */

        public static int flippingMatrix(List<List<Integer>> matrix, int n) {
            // Write your code here
            // 0+i, 0+j/ 0+i, 2n-1-j/ 2n-1-i, 0+j/ 2n-1-i, 2n-1-j
            int sum = 0;
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j++) {
                    int a1 = matrix.get(i).get(j);
                    int a2 = matrix.get(i).get(2*n-1-j);
                    int a3 = matrix.get(2*n-1-i).get(j);
                    int a4 = matrix.get(2*n-1-i).get(2*n-1-j);
                    int max1 = Math.max(a1, a2);
                    int max2 = Math.max(a3, a4);
                    sum += Math.max(max1, max2);
                }
            }
            return sum;
        }

    }
}

