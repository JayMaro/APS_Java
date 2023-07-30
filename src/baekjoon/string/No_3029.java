package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class No_3029 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime now = LocalTime.parse(br.readLine(), dateTimeFormatter);
        LocalTime timeToThrow = LocalTime.parse(br.readLine(), dateTimeFormatter);
        LocalTime result = timeToThrow.minusSeconds(now.getSecond()).minusMinutes(now.getMinute()).minusHours(now.getHour());
        String resultStr = result.format(dateTimeFormatter);
        if (resultStr.equals("00:00:00")) {
            resultStr = "24:00:00";
        }
        System.out.println(resultStr);
    }
}
