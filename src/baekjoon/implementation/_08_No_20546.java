package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _08_No_20546 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int budget = Integer.parseInt(br.readLine());
        List<Integer> priceList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int bnpBudget = budget;
        int bnpStock = 0;

        int timingBudget = budget;
        int timingStock = 0;
        int timingStream = 0;
        int timingBeforePrice = priceList.get(0);
        // bnp
        for (int i = 0; i < priceList.size(); i++) {
            int price = priceList.get(i);
            int bnpValue = bnpBudget / price;
            bnpStock += bnpValue;
            bnpBudget = bnpBudget % price;
            if (bnpBudget == 0) {
                break;
            }
        }
        // timing
        for (int i = 0; i < priceList.size(); i++) {
            int price = priceList.get(i);

            if (price == timingBeforePrice) {
                timingStream = 0;
            } else if (price > timingBeforePrice) {
                if (timingStream >= 0) {
                    timingStream++;
                } else {
                    timingStream = 1;
                }
            } else {
                if (timingStream <= 0) {
                    timingStream--;
                } else {
                    timingStream = -1;
                }
            }
            timingBeforePrice = price;

            if (timingStream >= 3) {
                timingBudget += timingStock * price;
                timingStock = 0;
            } else if (timingStream <= -3) {
                int timingValue = timingBudget / price;
                timingStock += timingValue;
                timingBudget = timingBudget % price;
            }
        }

        int bnpResult = bnpStock * priceList.get(priceList.size() - 1) + bnpBudget;
        int timingResult = timingStock * priceList.get(priceList.size() - 1) + timingBudget;

        System.out.println(bnpResult);
        System.out.println(timingResult);

        if (bnpResult > timingResult) {
            System.out.println("BNP");
        } else if (bnpResult < timingResult) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
