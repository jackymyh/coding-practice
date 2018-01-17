import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class verticalOrder {
	private static void printVerticalOrder(BiNode root) {
		if (root == null) return;
		
		HashMap<Integer, List<Integer>> levelMap = new HashMap<>();
		
		getVerticalOrder(root, 0, levelMap);
		
		Object[] keys = levelMap.keySet().toArray();
		
		Arrays.sort(keys);
		
		for (Object level : keys) {
			List<Integer> vLevel = levelMap.get(level);
			System.out.print(level + ": ");
			for (Integer nodeVal : vLevel) {
				System.out.print(nodeVal + " ");
			}
			System.out.println("");
		}
	}
	
	private static void getVerticalOrder(BiNode node, int level, HashMap<Integer, List<Integer>> levelMap) {
		List<Integer> vLevel = new ArrayList<>();
		if (levelMap.containsKey(level)) {
			vLevel = levelMap.get(level);
			vLevel.add(node.data);
			levelMap.put(level, vLevel);
		} else {
			vLevel.add(node.data);
			levelMap.put(level, vLevel);
		}
		
		if (node.left != null) {
			getVerticalOrder(node.left, level - 1, levelMap);
		}
		
		if (node.right != null) {
			getVerticalOrder(node.right, level + 1, levelMap);
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
		
		printVerticalOrder(root);
	}
}