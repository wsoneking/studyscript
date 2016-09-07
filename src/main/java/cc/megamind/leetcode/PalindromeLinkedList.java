package cc.megamind.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromeLinkedList {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode p = head;
		List<Integer> list = Arrays.asList(2,3,4,2,1);
		
		for(int i : list) {
			p.next = new ListNode(i);
			p = p.next;
		}
		printout(head);
		System.out.println(isPalindrome(head));
	}
	
	
	public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        //get the center node
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null) {
            if(fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                continue;
            }
            ListNode p = slow;
            slow = slow.next;
            p.next = null;
            break;
        }
        ListNode p1 = (slow.next == null) ? slow : slow.next;
        ListNode p2 = p1.next;
        
        slow.next = null;
        while(p2 != null) {
            p1.next = slow;
            slow = p1;
            p1 = p2;
            p2 = p2.next;
        }
        p1.next = slow;
        ListNode pp = p2 == null ? (p1 == null ? slow : p1) : p2;
        
        printout(head);
        printout(pp);
        //compare head and pp
        while(head != null && pp != null) {
            System.out.println("head,pp = "+head.val+","+pp.val);
            if(head.val != pp.val){
                return false;
            }
            head = head.next;
            pp = pp.next;
        }
        return true;
    }
    public static void printout(ListNode p) {
        while(p != null) {
            System.out.print(" -> "+ p.val);
            p = p.next;
        }
        System.out.println();
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}