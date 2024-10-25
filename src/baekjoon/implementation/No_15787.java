package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class No_15787 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        HashMap<Integer, Train> trainMap = new HashMap<>();
        int resCount = 0;
        List<Train> trains = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            trainMap.put(i, new Train(i));
        }
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int method = Integer.parseInt(input[0]);
            int trainIndex = Integer.parseInt(input[1]);
            int seatNum = -1;
            if (method == 1 || method == 2) {
                seatNum = Integer.parseInt(input[2]);
            }
            Train train = trainMap.get(trainIndex);
            train.runMethod(method, seatNum);
        }
        for (Entry<Integer, Train> entry : trainMap.entrySet()) {
            Train value = entry.getValue();
            boolean isNotDup = true;
            for (Train t : trains) {
                if (t.isDuplicated(value)) {
                    isNotDup = false;
                    break;
                }
            }
            if (isNotDup) {
                trains.add(value);
                resCount++;
            }
        }
        System.out.println(resCount);
    }

    public static class Train {
        boolean[] seat;
        int order;

        public Train(int order) {
            this.seat = new boolean[20];
            this.order = order;
        }

        public boolean isDuplicated(Train train) {
            for (int i = 0; i < 20; i++) {
                if (train.seat[i] != this.seat[i]) {
                    return false;
                }
            }
            return true;
        }

        public void runMethod(int method, int x) {
            if (method == 1) {
                this.m1(x);
            } else if (method == 2) {
                this.m2(x);
            } else if (method == 3) {
                this.m3();
            } else {
                this.m4();
            }
        }

        private void m1(int x) {
            seat[x - 1] = true;
        }

        private void m2(int x) {
            seat[x - 1] = false;
        }

        private void m3() {
            boolean[] temp = new boolean[20];
            System.arraycopy(this.seat, 0, temp, 1, 19);
            this.seat = temp;
        }

        private void m4() {
            boolean[] temp = new boolean[20];
            System.arraycopy(this.seat, 1, temp, 0, 19);
            this.seat = temp;
        }
    }
}
