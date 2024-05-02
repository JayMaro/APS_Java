package hanteo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No2 {

    public static void main(String[] args) {
        Solution sol = new Solution(4, new int[]{1, 2, 3});
        sol.findResult();
    }

    static class Solution {
        int sum;
        int[] coins;
        int coinLen;
        LinkedList<Integer> nowList;
        int result;
        List<List<Integer>> resultList;

        public Solution(int sum, int[] coins) {
            this.sum = sum;
            this.coins = coins;
            this.coinLen = coins.length;
        }

        public void findResult() {
            result = 0;
            nowList = new LinkedList<>();
            resultList = new ArrayList<>();
            recursive(0, 0);
            System.out.println("result = " + result);
            System.out.println("resultList = " + resultList);
        }

        public void recursive(int startIdx, int nowSum) {
            if (nowSum > sum) {
                return;
            }
            if (nowSum == sum) {
                result++;
                List<Integer> temp = new ArrayList<>(nowList);
                resultList.add(temp);
            }
            for (int i=startIdx; i<coinLen; i++) {
                nowList.addLast(coins[i]);
                recursive(i, nowSum+coins[i]);
                nowList.removeLast();
            }
        }

    }
}
