/**
Medium
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        printList(l1);
        System.out.println();
        printList(l2);
        return reverse(addTwoR(l1,l2));
    }
    public void printList(ListNode l1){
        while(l1!=null){
            System.out.print(l1.val);
            System.out.print(" ");
            l1 = l1.next;
        }
    }
    public ListNode addTwoR(ListNode l1, ListNode l2){
        int carry = 0;
        int next = l1.val + l2.val;
        carry = next/10;
        ListNode res = new ListNode(next%10);
        ListNode ptr = res;
        l1 = l1.next;
        l2 = l2.next;
        while(l1!=null && l2!=null){
            next = l1.val + l2.val + carry;
            carry = next/10;
            ptr.next = new ListNode(next%10);
            ptr = ptr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            next = l1.val + carry;
            ptr.next = new ListNode(next%10);
            ptr = ptr.next;
            carry = next/10;
            l1 = l1.next;
        }
        while(l2!=null){
            next = l2.val + carry;
            ptr.next = new ListNode(next%10);
            ptr = ptr.next;
            carry = next/10;
            l2 = l2.next;
        }
        if(carry==1){
            ptr.next = new ListNode(1);
        }
        return res;
    }

    public ListNode reverse(ListNode a){
        if(a== null || a.next == null){
            return a;
        }
        ListNode res = reverse(a.next);
        a.next.next = a;
        a.next = null;
        return res;
    }
    public int reverseNum(int a){
        int b = 0;
        while(a>0){
            b *=10;
            b += a%10;
            a=a/10;
        }
        return b;
    }
}
