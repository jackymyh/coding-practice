import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

class Connection {
	String node1;
	String node2;
	int cost;
	Connection(String a, String b, int c){
		node1 = a;
		node2 = b;
		cost = c;
	}
}

public class MST {
	
	public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
		ArrayList<Connection> result = new ArrayList<>();
		HashMap<String, String> sets = new HashMap<>();
		
		if (connections == null || connections.isEmpty()) {
			return result;
		}
		
		//sort connections in ascending order
		connections.sort(new Comparator<Connection>() {
			@Override
			public int compare(Connection a, Connection b) {
				return a.cost - b.cost;
			}
		});
		
		for (Connection edge : connections) {
			if (union(sets, edge)) {
				result.add(edge);
			}
		}
		
		result.sort(new Comparator<Connection>() {
			@Override
			public int compare(Connection a, Connection b) {
				if (a.node1.equals(b.node1)) {
					return a.node2.compareTo(b.node2);
				} else {
					return a.node1.compareTo(b.node1);
				}
			}
		});
		
		return result;
	}
	
	public static boolean union(HashMap<String, String> sets, Connection edge) {
		if (!sets.containsKey(edge.node1) && !sets.containsKey(edge.node2)) {
			sets.put(edge.node1, edge.node1);
			sets.put(edge.node2, edge.node1);
			return true;
		} else if (sets.containsKey(edge.node1) && !sets.containsKey(edge.node2)) {
			sets.put(edge.node2, sets.get(edge.node1));
			return true;
		} else if (sets.containsKey(edge.node2) && !sets.containsKey(edge.node1)) {
			sets.put(edge.node1, sets.get(edge.node2));
			return true;
		} else {
			String set1 = sets.get(edge.node1);
			String set2 = sets.get(edge.node2);
			
			//if nodes belong to different sets, merge the sets
			if (!set1.equals(set2)) {
				for (String node : sets.keySet()) {
					if (sets.get(node).equals(set2)) {
						sets.put(node, set1);
					}
					//System.out.println(node + "|" + sets.get(node));
				}
				//System.out.println("=============");
				return true;
			}
			//if nodes belong to same set
			return false;
		}
	}

	public static void main(String[] args) {
		ArrayList<Connection> connections = new ArrayList<>();
		connections.add(new Connection("A","B",2));
		connections.add(new Connection("B","C",4));
		connections.add(new Connection("C","D",5));
		connections.add(new Connection("D","E",8));
		connections.add(new Connection("E","F",2));
		connections.add(new Connection("B","F",10));
		connections.add(new Connection("E","C",9));
		connections.add(new Connection("F","C",7));
		connections.add(new Connection("B","E",3));
		connections.add(new Connection("A","F",16));

		ArrayList<Connection> result = getLowCost(connections);
		
		if (result.isEmpty()) {
			System.out.println("No connection");
		}
		
		for (Connection c : result){
			System.out.println(c.node1 + " -> " + c.node2 + " : " + c.cost);
		}
	}
}