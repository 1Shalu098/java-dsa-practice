
/*
 * 61. Rotate List

Medium

premium lock icon

Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Leetcode61 {
     public ListNode rotateRight(ListNode head, int k) {
        if(head == null|| head.next == null || k==0) return head;
        int l =1;
       ListNode tail = head;
       while(tail.next != null){
        tail = tail.next;
        l++;
       }
       k = k%l;
       if(k ==0) return head;
       tail.next = head;
       int remain = l-k;
       ListNode newtail = head;
       for(int i=1; i<remain; i++){
        newtail = newtail.next;
       }
       ListNode newhead = newtail.next;
       newtail.next = null;
       return newhead;
    }
    public static void main(String[] args) {
        Leetcode61 solution = new Leetcode61();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        int k1 = 2;
        ListNode result1 = solution.rotateRight(head1, k1);
        // System.out.printl(result1); // Output: 4 -> 5 -> 1 -> 2 -> 3

        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        int k2 = 4;
        ListNode result2 = solution.rotateRight(head2, k2);
        System.out.println(result2); // Output: 2 -> 0 -> 1
    }
    
}
