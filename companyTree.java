import java.util.ArrayList;

class Node {
	int val;
	ArrayList<Node> children;
	Node(int val) {
		this.val = val;
		this.children = new ArrayList<Node>();
	}
}

class Helper {
	int sum;
	int count;
	double avg;
	Node result;
	Helper(int sum, int count, double avg, Node result) {
		this.sum = sum;
		this.count = count;
		this.avg = avg;
		this.result = result;
	}
}

public class companyTree {

	public static Node maxAvg(Node root) {
		if (root == null || root.children.isEmpty()) {
			return null;
		}
		
		Helper tree = DFS(root);
		
		System.out.println("[" + tree.result.val + "," + tree.avg + "]");
		
		return tree.result;
	}
	
	private static Helper DFS(Node node) {
		Helper total = new Helper(node.val, 1, Double.MIN_VALUE, null);
		
		//dfs node's children for maxAvg
		for (Node child : node.children) {
			Helper subtree = DFS(child);
			total.sum += subtree.sum;
			total.count += subtree.count;
			
			if (total.avg < subtree.avg) {
				total.avg = subtree.avg;
				total.result = subtree.result;
				System.out.println("node: "+ node.val + " [sum: " + total.sum + ", count: " + total.count + ", avg: " + total.avg + "]");
			}
		}
		
		//if node is not a leaf, get avg of this subtree
		if (!node.children.isEmpty()) {
			double nodeAvg = (double)total.sum/total.count;
			if (total.avg < nodeAvg) {
				total.avg = nodeAvg;
				total.result = node;
				System.out.println("[subtree@: " + total.result.val + ", avg: " + total.avg + "]");
			}
		}
		
		return total;
	}
	
	public static void main(String[] args) {
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);
        Node l41 = new Node(3);
        Node l42 = new Node(4);
        Node l43 = new Node(4);
        Node l44 = new Node(8);
        
        l32.children.add(l44);
        
        l31.children.add(l41);
        l31.children.add(l42);
        l31.children.add(l43);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);
        
        maxAvg(root);
        
	}
}