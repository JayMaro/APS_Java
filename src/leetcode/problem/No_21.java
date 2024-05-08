package leetcode.problem;

public class No_21 {
    // 21. Merge Two Sorted Lists

    public static void main(String[] args) {
        class Solution {
            public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
                ListNode head = new ListNode();
                ListNode now = head;
                while (list1 != null && list2 != null) {
                    if (list1.val < list2.val) {
                        ListNode newNode = new ListNode(list1.val);
                        now.next = newNode;
                        now = now.next;
                        list1 = list1.next;
                    } else {
                        ListNode newNode = new ListNode(list2.val);
                        now.next = newNode;
                        now = now.next;
                        list2 = list2.next;
                    }
                }
                while (list1 != null) {
                    ListNode newNode = new ListNode(list1.val);
                    now.next = newNode;
                    now = now.next;
                    list1 = list1.next;
                }
                while (list2 != null) {
                    ListNode newNode = new ListNode(list2.val);
                    now.next = newNode;
                    now = now.next;
                    list2 = list2.next;
                }
                return head.next;
            }
        }
    }
}
