package hackerrank;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class RecursiveDigitSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static class Result {

        /*
         * Complete the 'superDigit' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. STRING n
         *  2. INTEGER k
         */

        public static int superDigit(String n, int k) {

            long p = getSuperDigit(n) * k;
            while (p / 10 != 0) {
                p = getSuperDigit(String.valueOf(p));
            }
            return (int) p;
        }

        public static long getSuperDigit(String n) {
            char[] chars = n.toCharArray();
            long sum = 0;
            for (int i = 0; i < chars.length; i++) {
                sum += chars[i] - 48;
            }
            return sum;
        }
    }
}
