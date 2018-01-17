import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class mazePath {

	public static List<Point> findPath(int[][] maze, Point start) {
		List<Point> path = new ArrayList<>();
		Deque<Point> stack = new LinkedList<>();
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		
		if (maze.length == 0 || maze[0].length == 0) return path;
		
		DFS(maze, start, stack, visited, false);
		
		while (!stack.isEmpty()) {
			path.add(stack.pollLast());
		}
		
		return path;
	}
	
	private static boolean DFS(int[][] maze, Point pos, Deque<Point> stack, boolean[][] visited, boolean found) {
		if ((pos.x < maze[0].length && pos.x >= 0) && (pos.y < maze.length && pos.y >= 0)) {
			if (!visited[pos.y][pos.x]) {
				visited[pos.y][pos.x] = true;
				if (maze[pos.y][pos.x] == 9) {
					stack.offer(pos);
					return true;
				}
				else if (maze[pos.y][pos.x] == 1) {
					//down
					if (!found) found = DFS(maze, new Point(pos.x, pos.y + 1), stack, visited, found);
					//right
					if (!found) found = DFS(maze, new Point(pos.x + 1, pos.y), stack, visited, found);
					//left
					if (!found) found = DFS(maze, new Point(pos.x - 1, pos.y), stack, visited, found);
					//up
					if (!found) found = DFS(maze, new Point(pos.x, pos.y - 1), stack, visited, found);

					if (found) {
						stack.offer(pos);
						return true;
					}
				}
				else {
					return false;
				}
			}
			return false;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] maze = {{1,0,0,1,0,0},
					    {1,0,1,1,1,1},
					    {1,1,1,0,1,0},
					    {1,0,1,0,1,0},
					    {1,1,1,0,1,1},
					    {1,0,1,1,0,9}};
		
		Point start = new Point(0,0);
		
		List<Point> path = findPath(maze, start);
		
		if (path.isEmpty()) System.out.println("No Path");
		
		for (Point pos : path) {
			System.out.println("[" + pos.x + "," + pos.y + "]");
		}
	}
}