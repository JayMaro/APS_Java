package leetcode.problem;

import java.util.LinkedList;

public class No_234 {
    // 234. Palindrome Linked List

    class Solution {
        public boolean isPalindrome(ListNode head) {
            LinkedList<ListNode> queue = new LinkedList<>();
            while (head != null) {
                queue.add(head);
                head = head.next;
            }
            while (queue.size() > 1) {
                ListNode first = queue.removeFirst();
                ListNode last = queue.removeLast();
                if (last.val != first.val) {
                    return false;
                }
            }
            return true;
        }
    }
}
