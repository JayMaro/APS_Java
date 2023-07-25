package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No_2753 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int year = Integer.parseInt(input);

        boolean isMultipleOf4 = ((year % 4) == 0);
        boolean isMultipleOf100 = ((year % 100) == 0);
        boolean isMultipleOf400 = ((year % 400) == 0);

        boolean isLeapYear = isMultipleOf400 || (isMultipleOf4 && !isMultipleOf100);
        bw.write(isLeapYear ? "1" : "0");
        bw.flush();
    }
}
