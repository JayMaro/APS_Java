package leetcode.problem;

import java.util.LinkedList;

public class No_206 {

    public static void main(String[] args) {
        class ListNode {

            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        class Solution {
            public ListNode reverseList(ListNode head) {
                LinkedList<ListNode> stack = new LinkedList<>();
                ListNode now = head;
                while (now != null) {
                    stack.addLast(now);
                    now = now.next;
                }
                if (stack.size() <= 1) {
                    return head;
                }
                ListNode last = stack.removeLast();
                ListNode prev = stack.removeLast();
                last.next = prev;
                while (stack.size() != 0) {
                    now = stack.removeLast();
                    prev.next = now;
                    prev = now;
                }
                head.next = null;
                return last;
            }
        }
    }
}
