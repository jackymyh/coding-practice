public class reverseList {
	//Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode reverseLinkedList(ListNode head) {
		ListNode prev, cur, pre;

		if (head == null) return null;
		if (head.next == null) return head;

		if (head.next.next != null) {
			prev = head;
			cur = head.next;
			pre = head.next.next;
			prev.next = null;
		} else {
			cur = head.next;
			cur.next = head;
			head.next = null;
			return cur;
		}

		while (pre != null) {
			cur.next = prev;
			prev = cur;
			cur = pre;
			pre = pre.next;
		}

		cur.next = prev;
		return cur;
	}
}