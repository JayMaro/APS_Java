package leetcode.problem;

public class No_876 {

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
            public ListNode middleNode(ListNode head) {
                ListNode[] listNodes = new ListNode[100];
                ListNode now = head;
                int count = 0;
                while (now != null) {
                    listNodes[count++] = now;
                    now = now.next;
                }
                return listNodes[count/2];
            }
        }
    }
}
