package hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;


public class PalindromeIndex {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.palindromeIndex(s);

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
         * Complete the 'palindromeIndex' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts STRING s as parameter.
         */

        public static int palindromeIndex(String s) {
            String reverse = new StringBuilder(s).reverse().toString();
            if (reverse.equals(s)) {
                return -1;
            }
            for (int i = 0; i < (s.length() / 2); i++) {
                if (s.charAt(i) != reverse.charAt(i)) {
                    boolean isPan = true;
                    StringBuilder sb = new StringBuilder(s).deleteCharAt(i);
                    String removed = sb.toString();
                    String removedReverse = sb.reverse().toString();
                    for (int j = 0; j < (s.length() / 2); j++) {
                        if (removed.charAt(j) != removedReverse.charAt(j)) {
                            isPan = false;
                            break;
                        }
                    }
                    if (isPan) {
                        return i;
                    }
                    isPan = true;
                    sb = new StringBuilder(reverse).deleteCharAt(i);
                    removed = sb.toString();
                    removedReverse = sb.reverse().toString();
                    for (int j = 0; j < (s.length() / 2); j++) {
                        if (removed.charAt(j) != removedReverse.charAt(j)) {
                            isPan = false;
                            break;
                        }
                    }
                    if (isPan) {
                        return s.length() - i - 1;
                    }
                    return -1;
                }
            }
            return -1;
        }
    }
}
