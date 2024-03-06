package leetcode.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class No_70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(35));
    }



    public static int climbStairs(int n) {
        LinkedList<Object[]> queue = new LinkedList<>();
        Set<String> resultList = new HashSet<>();
        Set<String> reqList = new HashSet<>();
        queue.add(new Object[]{0, ""});
        while (queue.size() != 0) {
            Object[] valueArray = queue.removeFirst();
            if ((Integer) valueArray[0] > n) {
                continue;
            }
            if (reqList.contains((String) valueArray[1])) {
                continue;
            }
            reqList.add((String) valueArray[1]);
            if ((Integer) valueArray[0] == n) {
                resultList.add((String) valueArray[1]);
            }
            queue.addLast(new Object[]{(Integer) valueArray[0] + 2, (String) valueArray[1] + 2});
            queue.addLast(new Object[]{(Integer) valueArray[0] + 1, (String) valueArray[1] + 1});
        }
        return resultList.size();
    }
}
