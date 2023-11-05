package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static String timeConversion(String s) {
        // Write your code here
        boolean isPM = s.endsWith("PM");
        String time = s.substring(0, 8);
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        if (isPM) {
            if (hour != 12) {
                times[0] = String.format("%02d", hour + 12);
            }
        } else {
            if (hour == 12) {
                times[0] = String.format("%02d", hour - 12);
            }
        }
        return String.join(":", times);
    }
}
