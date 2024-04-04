package leetcode.problem;

public class No_121 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int minVal = 10000;
        for (int i=0; i<prices.length; i++) {
            if (minVal <= prices[i]) {
                continue;
            }
            minVal = prices[i];
            int maxVal = 0;
            for (int j=i+1; j<prices.length; j++) {
                if (prices[j] < maxVal) {
                    continue;
                }
                if (prices[j] - prices[i] > profit) {
                    profit = prices[j] - prices[i];
                    maxVal = prices[j];
                }
            }
        }
        return profit;
    }

}
