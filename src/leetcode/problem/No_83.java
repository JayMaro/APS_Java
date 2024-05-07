package leetcode.problem;

public class No_83 {
    //83. Remove Duplicates from Sorted List
    public static void main(String[] args) {

        class Solution {
            public ListNode deleteDuplicates(ListNode head) {
                ListNode now = head;
                ListNode prev = new ListNode(101, now);
                while (now != null) {
                    if (now.val == prev.val) {
                        prev.next = now.next;
                    } else {
                        prev = prev.next;
                    }
                    now = now.next;
                }

                return head;
            }
        }
    }
}
