public class lowestCommonAncestor {
	private static BiNode LCA(BiNode node, BiNode a, BiNode b) {
		if (node == null) return null;
		
		if (node == a || node == b) return node;
		
		BiNode left = null, right = null;
		
		if (node.left != null) {
			left = LCA(node.left, a, b);
		}
		
		if (node.right != null) {
			right = LCA(node.right, a, b);
		}
		
		if (left == null && right != null) {
			return right;
		} else if (left != null && right == null) {
			return left;
		} else if (left != null && right != null) {
			return node;
		} else {
			return null;
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
		
		System.out.println(LCA(root, second1, second2).data); //2
		System.out.println(LCA(root, first1, second1).data); //1
	}
}