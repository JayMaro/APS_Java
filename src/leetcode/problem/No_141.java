package leetcode.problem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class No_141 {

    public static void main(String[] args) {
        class ListNode {

            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
                next = null;
            }
        }

        class Solution {

            ListNode head;

            public Solution(int[] numArr, int pos) {
                head = new ListNode(numArr[0]);
                List<ListNode> nodeList = new ArrayList<>();
                nodeList.add(head);
                ListNode now = head;
                for (int i=1;i<numArr.length;i++) {
                    now.next = new ListNode(numArr[i]);
                    now = now.next;
                    nodeList.add(now);
                }
                now.next = nodeList.get(pos);
            }


            public boolean hasCycle(ListNode head) {
                ListNode fast = head;
                ListNode slow = head;
                while (fast != null && fast.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                    if (fast == slow) {
                        return true;
                    }
                }
                return false;
            }

        }

        Solution sol = new Solution(new int[]{3, 2, 0, -4}, 1);
        sol.hasCycle(sol.head);
    }
}
