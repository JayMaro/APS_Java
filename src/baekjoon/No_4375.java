package baekjoon;

import java.util.Scanner;

public class No_4375 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int result = 1;
            long number = 1;
            while (number % n != 0) {
                number = (number % n) * 10 + 1;
                result ++;
            }
            System.out.println(result);
        }
    }

}
