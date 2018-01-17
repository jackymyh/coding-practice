class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class addTwoNum {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0;
		ListNode result = new ListNode(0);
		ListNode head = result;
		ListNode prev = null;

		while (l1 != null || l2 != null) {
			if (sum >= 10) {
				sum /= 10;
			} else {
				sum = 0;
			}

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			result.val = sum % 10;
			result.next = new ListNode(0);
			prev = result;
			result = result.next;
		}

		if (sum / 10 == 1) {
			prev.next.val = 1;
		} else {
			prev.next = null;
		}

		return head;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(7); // 907
		l1.next = new ListNode(0);
		l1.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(5); // 5165
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(1);
		l2.next.next.next = new ListNode(5);
		
		ListNode result = addTwoNumbers(l1,l2); //6072
		
		while(result != null) {
			System.out.print(result.val);
			result = result.next;
		}
	}
}
