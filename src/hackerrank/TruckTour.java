package hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class TruckTour {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static class Result {

        public static int truckTour(List<List<Integer>> petrolpumps) {
            // Write your code here
            int len = petrolpumps.size();
            for (int i = 0; i < len; i++) {
                long nowPetrol = 0;
                long nowMeter = 0;
                int end = i;
                boolean isRound = true;
                for (int j = 1; j <= len + 1; j++) {
                    List<Integer> list = petrolpumps.get(end % len);
                    Integer petrol = list.get(0);
                    Integer meter = list.get(1);
                    nowPetrol += petrol;
                    nowMeter += meter;
                    if (nowMeter > nowPetrol) {
                        isRound = false;
                        break;
                    }
                    end = i + j;
                }
                if (isRound) {
                    return i;
                }
            }
            return -1;
        }

    }
}
