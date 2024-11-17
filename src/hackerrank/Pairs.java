package hackerrank;


import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


public class Pairs {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static class Result {

        /*
         * Complete the 'pairs' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER k
         *  2. INTEGER_ARRAY arr
         */

        public static int pairs(int k, List<Integer> arr) {
            // Write your code here
            int start = 0;
            int end = 1;
            int len = arr.size();
            int count = 0;
            arr.sort(Comparator.naturalOrder());
            while (start < len) {
                int val = arr.get(end) - arr.get(start);
                if (val == k) {
                    count++;
                    start++;
                } else if (val > k) {
                    start++;
                } else {
                    if (end == len - 1) {
                        start++;
                    } else {
                        end++;
                    }
                }
            }
            return count;
        }

    }
}

