import java.util.HashMap;

public class LRUCache {
	private class LinkedNode {
		LinkedNode prev, next;
		int key, value;
		LinkedNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private int maxCap, count;
	private HashMap<Integer, LinkedNode> map;
	private LinkedNode head, tail;
	
    public LRUCache(int capacity) {
        this.maxCap = capacity;
        this.count = 0;
        this.map = new HashMap<>();
        this.head = new LinkedNode(0,0);
        this.tail = new LinkedNode(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        LinkedNode node = map.getOrDefault(key, null);
        
        if (node == null) {
        	throw new NullPointerException();
        }
        
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        LinkedNode node = map.getOrDefault(key, null);
        
        if (node == null) {
        	node = new LinkedNode(key, value);
        	map.put(key, node);
        	addFirst(node);
        	count++;
        } else {
        	node.value = value;
        	update(node);
        }
        
        if (count > this.maxCap) {
        	map.remove(tail.prev.key);
        	remove(tail.prev);
        	count--;
        }
        
        LinkedNode iterator = head;
        while (iterator != null) {
        	System.out.print(iterator.key + " ");
        	iterator = iterator.next;
        }
        System.out.println("");
    }
    
    private void update(LinkedNode node) {
    	remove(node);
    	addFirst(node);
    }
    
    private void addFirst(LinkedNode node) {
    	System.out.println("Insert: " + node.key); 
    	LinkedNode temp = head.next;
    	head.next = node;
    	node.prev = head;
    	node.next = temp;
    	temp.prev = node;
    	System.out.print("H.next: " + head.next.key); 
    	System.out.println(" T.prev: " + tail.prev.key); 
    }
    
    private void remove(LinkedNode node) {
    	System.out.println("Remove: " + node.key);
    	node.next.prev = node.prev;
    	node.prev.next = node.next;
    	System.out.print("H.next: " + head.next.key); 
    	System.out.println(" T.prev: " + tail.prev.key); 
    }
    
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache(2);
    	
    	cache.put(1, 1);
    	cache.put(2, 2);
    	cache.put(3, 3);
    	cache.put(1, 1);
    	cache.put(1, 1);
    	
    	cache.get(3);
    	
    	System.out.println(cache.map.keySet());
    }
}