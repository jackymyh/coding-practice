import java.util.Comparator;
import java.util.PriorityQueue;

class Point
{
    double x;
    double y;
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
}

public class kNearest {
    private static double distance(Point a, Point b)
    {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
    
    private static Point[] kNN(Point[] input, final Point origin, int k) {
    	Comparator comp = new Comparator<Point>() {
    		@Override
    		public int compare (Point a, Point b) {
    			if (distance(a, origin) < distance(b, origin)) {
    				return -1;
    			} else if (distance(a, origin) > distance(b, origin)) {
    				return 1;
    			} else return 0;
    		}
    	};
    	PriorityQueue<Point> pq = new PriorityQueue<>(k, comp);
    	
    	if (input.length <= k) {
    		return input;
    	}
    	
    	for (Point p : input) {
    		pq.add(p);
    	}
    	
    	Point[] result = new Point[k];
    	for (int i = 0; i < k; i++) {
    		result[i] = pq.poll();
    	}
    	
    	return result;
    	
    }
    
    public static void main(String[] args)
    {
        Point origin = new Point(0, 0);
        Point[] input = new Point[]{new Point(0, 2), new Point(1, 1), new Point(-1, 0), new Point(2, 0), new Point(3, 0), new Point(2, 0), 
        		new Point(2, -3), new Point(2, 5), new Point(1, 0), new Point(0, 0), new Point(8, 3), new Point(2, 9), new Point(5, 5), 
        		new Point(2, 4), new Point(1, 2), new Point(-6, 4), new Point(-1, -5), new Point(-2, -1), new Point(3, -3), new Point(4, -1)};
        Point[] output = kNN(input, origin, 5);
        System.out.println("input");
        for(Point i : input) System.out.print("("+i.x+", "+i.y+") ");
        System.out.println("");
        System.out.println("output");
        for(Point i : output) System.out.print("("+i.x+", "+i.y+") ");
         
         
    }
}