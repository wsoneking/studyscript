package cc.megamind.leetcode;

import cc.megamind.leetcode.AddTwoNumbers.ListNode;

public class PartitionList {

	public static void main(String[] args) {
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(1);
//		l2.next.next = new ListNode(2);
//		l2.next.next.next = new ListNode(5);
		
		ListNode ans = partition(l2, 2);
		while(ans.next != null) {
			System.out.print(ans.val +" -> ");
			ans = ans.next;
		}
		System.out.println(ans.val);
	}
	
	public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head; 
        }
        ListNode bighead = null;
        ListNode bigend = null;
        ListNode smallhead = null;
        ListNode smallend = null;
        ListNode index = head;
        while(index != null) {
            if(index.val >= x) {
                if(bighead == null) {
                    bighead = index;
                    bigend = index;
                    index = index.next;
                    bigend.next = null;
                } else {
                    bigend.next = index;
                    index = index.next;
                    bigend = bigend.next;
                    bigend.next = null;
                }
            } else {
                if(smallhead == null) {
                    smallhead = index;
                    smallend = index;
                    index = index.next;
                    smallend.next = null;
                } else {
                    smallend.next = index;
                    index = index.next;
                    smallend = smallend.next;
                    smallend.next = null;
                }
            }
        }

        if(smallhead == null) {
            return bighead;
        }
        smallend.next = bighead;
        return smallhead;
    }
}
