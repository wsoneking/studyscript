package cc.megamind.leetcode;

import cc.megamind.leetcode.AddTwoNumbers.ListNode;

public class ReverseLinkedList2 {

public static void main(String[] args) {
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(3);
		l2.next.next.next = new ListNode(4);
		l2.next.next.next.next = new ListNode(5);
		
		ListNode ans = reverseBetween(l2, 2, 4);
		while(ans.next != null) {
			System.out.print(ans.val +" -> ");
			ans = ans.next;
		}
		System.out.println(ans.val);
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {
            return head;
        }
        
        int midnum = 1;
        ListNode slow = head;
        ListNode mid = head;
        ListNode fast = head.next;
        ListNode ff = head.next.next;
        
        while(fast!=null) {
            if(midnum == m) {
                fast.next = mid;
                mid.next = null;
            } else if(midnum > m){
                fast.next = mid;
            } else {
                slow = mid;
            }
            
            if(midnum == n) {
            	fast.next = ff;
                slow.next.next = fast;
                slow.next = mid;    
                break;
            }
            midnum++;
            mid = fast;
            fast = ff;
            if(ff != null)
            	ff = ff.next;
        }
        
        return head;
    }
}
