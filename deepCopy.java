import java.util.HashMap;

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}

public class deepCopy {

	public static RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

		RandomListNode current = head;

		//iterate over original and create copies of nodes and associate copy with their original in HashMap
		while (current != null) {
			RandomListNode copy = new RandomListNode(current.label);
			map.put(current, copy);
			current = current.next;
		}

		//iterate over original in HashMap and get the nodes that the originals point to and use as key to set the associated copies to point to the associated nodes 
		current = head;
		while (current != null) {
			map.get(current).next = map.get(current.next);
			map.get(current).random = map.get(current.random);
			current = current.next;
		}

		//return the head of the copy
		return map.get(head);
	}
	
	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		
		node1.random = node4;
		node2.random = null;
		node3.random = node4;
		node4.random = node2;
		
		RandomListNode copy = copyRandomList(node1);
		
		while (copy != null) {
			System.out.println(copy.label);
			copy = copy.next;
		}
	}
}