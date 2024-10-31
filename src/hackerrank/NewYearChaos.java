package hackerrank;


import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class NewYearChaos {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

    public static class Result {

        /*
         * Complete the 'minimumBribes' function below.
         *
         * The function accepts INTEGER_ARRAY q as parameter.
         */

        public static void minimumBribes(List<Integer> q) {
            // Write your code here
            for (int i = 0; i < q.size(); i++) {
                if (q.get(i) - (i + 1) > 2) {
                    System.out.println("Too chaotic");
                    return;
                }
            }
            int totalCount = 0;
            for (int i = 0; i < q.size(); i++) {
                int sortCount = 0;
                for (int j = 0; j < q.size() - 1; j++) {
                    if (q.get(j) > q.get(j + 1)) {
                        int temp = q.get(j);
                        q.set(j, q.get(j + 1));
                        q.set(j + 1, temp);
                        sortCount++;
                        totalCount++;
                    }
                }
                if (sortCount == 0) {
                    break;
                }
            }
            System.out.println(totalCount);
        }

        public static void minimumBribes1(List<Integer> q) {
            // Write your code here
            int[] visited = new int[q.size() + 1];
            boolean isChaotic = false;
            int totalBribedCount = 0;
            for (int i = q.size() - 1; i >= 0; i--) {
                Integer now = q.get(i);
                int bribedCount = 0;
                visited[now] = 1;
                for (int j = 1; j < now; j++) {
                    if (visited[j] == 1) {
                        bribedCount++;
                    }
                }
                if (bribedCount > 2) {
                    isChaotic = true;
                    break;
                }
                totalBribedCount += bribedCount;
            }
            if (isChaotic) {
                System.out.println("Too chaotic");
            } else {
                System.out.println(totalBribedCount);
            }
        }
    }
}
