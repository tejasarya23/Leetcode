/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }if(fast.next!=null)fast=fast.next;
        System.out.print(fast.val);
        ListNode cur=slow.next;
        ListNode prev=slow;
        ListNode mid=slow;
        while(cur!=null){
            slow=cur;
            cur=cur.next;    
            slow.next=prev;
            prev=slow;
        }
        // System.out.print(head.toString());
        while(fast!=mid){
            System.out.print("hi");
            if(fast.val!=head.val){
                return false;
            }
            fast=fast.next;
            head=head.next;
        }
        return true;
    }
    
}