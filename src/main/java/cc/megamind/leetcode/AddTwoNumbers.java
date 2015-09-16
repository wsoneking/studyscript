package cc.megamind.leetcode;

public class AddTwoNumbers {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		l2.next.next.next = new ListNode(5);
		
		ListNode ans = addTwoNumbers(l1,l2);
		while(ans.next != null) {
			System.out.print(ans.val +" -> ");
			ans = ans.next;
		}
		System.out.println(ans.val);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null && l2==null) {
			return null;
		} else if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else {
			ListNode node1 = l1;
			ListNode node2 = l2;
			int value = node1.val + node2.val;
			int unit = value/10;
			ListNode toReturn = new ListNode(value % 10);
			
			while( !(node1.next == null && node2.next == null && unit == 0)) {
				node1 = node1.next == null ? new ListNode(0) : node1.next;
				node2 = node2.next == null ? new ListNode(0) : node2.next;
				value = node1.val + node2.val + unit;
				unit = value/10;
				ListNode newNode = new ListNode(value%10);
				ListNode ptr = toReturn;
				while(ptr.next != null) {
					ptr = ptr.next;
				}
				ptr.next = newNode;
			}
			return toReturn;
			
		}
		
		
	}
}
