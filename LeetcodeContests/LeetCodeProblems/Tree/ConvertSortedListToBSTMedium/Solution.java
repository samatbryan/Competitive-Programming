/** 109. Convert Sorted List to Binary Search Tree
Medium

1372

78

Favorite


 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){return null;}
        int size  = getSize(head, 0);
        int nums[] = new int[size];
        populate(nums,head,0);

        return helper(nums, 0, nums.length - 1);
    }
    public TreeNode helper(int[] nums, int left, int right){
        if(left>right){
            return null;
        }
        int middle = left + (right - left)/2;
        TreeNode res = new TreeNode(nums[middle]);
        res.left = helper(nums, left, middle-1);
        res.right = helper(nums,middle + 1, right);
        return res;
    }

    public int getSize(ListNode head, int length){
        if(head == null){
            return length;
        }
        return getSize(head.next, length + 1);
    }
    public void populate(int[] nums, ListNode head, int index){
        if(head == null){
            return;
        }
        nums[index] = head.val;
        populate(nums,head.next, index+1);
    }
}
