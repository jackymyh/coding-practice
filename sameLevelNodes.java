import java.util.Deque;
import java.util.LinkedList;

class BiNode {
    int data;
    BiNode left, right, nextRight;
  
    BiNode(int item) 
    {
        data = item;
        left = right = nextRight = null;
    }
}

public class sameLevelNodes {
	private static void connect(BiNode root) {
		if (root == null) return;
		
		Deque<BiNode> queue = new LinkedList<>();
		
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int count = queue.size();
			while (count > 0) {
				BiNode temp = queue.poll();
				System.out.print(temp.data);
				//decrement node count of current level
				count--;
				
				//add children of temp to queue
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
				
				//no more nodes on current level
				if (count == 0) {
					temp.nextRight = null;
					System.out.println("");
				} else {
					temp.nextRight = queue.peek();
					System.out.print(" ");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BiNode root = new BiNode(1);
		BiNode first1 = new BiNode(2);
		BiNode first2 = new BiNode(3);
		BiNode second1 = new BiNode(4);
		BiNode second2 = new BiNode(5);
		BiNode second3 = new BiNode(6);
		
		root.left = first1;
		root.right = first2;
		root.left.left = second1;
		root.left.right = second2;
		root.right.left = second3;
		
		connect(root);
	}
}