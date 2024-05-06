package leetcode.problem;

public class No_203 {
    //203. Remove Linked List Elements

    public static void main(String[] args) {
        class Solution {
            public ListNode removeElements(ListNode head, int val) {
                ListNode now = head;
                ListNode prev = null;
                while (now != null) {
                    if (now.val == val) {
                        if (prev == null) {
                            head = head.next;
                        } else {
                            prev.next = now.next;
                        }
                    } else {
                        prev = now;
                    }
                    now = now.next;
                }

                return head;
            }
        }
    }
}
