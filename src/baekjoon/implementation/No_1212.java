package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1212 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        String inputOctNumber = br.readLine();
        String[] OctToBinaryList = {"000", "001", "010", "011", "100", "101", "110", "111"};
        for (int i = 0; i < inputOctNumber.length(); i++) {
            String num = OctToBinaryList[inputOctNumber.charAt(i) - '0'];
            sb.append(num);
        }
        if (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
    }

}
