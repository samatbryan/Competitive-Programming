/**
Medium
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int first = l1.val + l2.val;
        carry = first/10;
        ListNode res = new ListNode(first%10);
        ListNode ptr = res;
        l1 = l1.next;
        l2 = l2.next;

        while(l1!=null && l2!= null){
            int next = l1.val + l2.val + carry;
            carry = next/10;
            ptr.next = new ListNode(next%10);
            ptr = ptr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null ){
            int next = l1.val + carry;
            carry = next/10;
            ptr.next = new ListNode(next%10);
            ptr = ptr.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int next = l2.val + carry;
            carry = next/10;
            System.out.println("here");
            ptr.next = new ListNode(next%10);
            ptr = ptr.next;
            l2 = l2.next;
        }
        if(carry == 1){
            System.out.println("here2");
            ptr.next = new ListNode(1);
        }
        return res;

    }
}
