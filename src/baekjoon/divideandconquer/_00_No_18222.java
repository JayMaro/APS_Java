package baekjoon.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _00_No_18222 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());

        long multi2 = 1;
        while (multi2 < k) {
            multi2 *= 2;
        }
        Sol s = new Sol(k, multi2, false);
        System.out.println(s.solution());
    }

    public static class Sol {
        private long index;
        private long multi2;
        private boolean isFlip;

        public Sol(long index, long multi2, boolean isFlip) {
            this.index = index;
            this.multi2 = multi2;
            this.isFlip = isFlip;
        }

        public void dc() {
            while (multi2 >= index) {
                multi2 /= 2;
            }
            index -= multi2;
            isFlip = !isFlip;
        }

        public int solution() {
            while (index != 1) {
                this.dc();
            }
            return isFlip ? 1 : 0;
        }
    }
}
