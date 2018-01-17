import java.util.Deque;
import java.util.LinkedList;

public class courseSchedule {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] courses = new boolean[numCourses][numCourses];
        boolean[] visited = new boolean[numCourses];
        int[] result = new int[numCourses];
        Deque<Integer> order = new LinkedList<>();
        int count = 0;
        
        //put prerequisites into adjacency matrix
        for (int[] course : prerequisites) {
            courses[course[1]][course[0]] = true;
        }
        
        for (int pre = 0; pre < numCourses; pre++) {
            DFS(courses, pre, visited, order, numCourses, count);
        }
        
        if (order.size() != numCourses) return new int[0];
        
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.pollLast();
        }
        
        return result;
    }
    
    private static void DFS(boolean[][] courses, int pre, boolean[] visited, Deque<Integer> order, int numCourses, int count) {
        if (!visited[pre] && count <= numCourses) {
            for (int take = 0; take < numCourses; take++) {
                if (courses[pre][take]) {
                    count++;
                    DFS(courses, take, visited, order, numCourses, count);
                }
            }
            visited[pre] = true;
            order.add(pre);
        }
    }
    
    public static void main(String[] args) {
    	int numCourses = 4;
    	int numEdges = 6;
    	int[][] prereq = new int[numEdges][];
    	
    	int[] edge1 = {1,0};
    	int[] edge2 = {2,0};
    	int[] edge3 = {2,1};
    	int[] edge4 = {3,1};
    	int[] edge5 = {3,2};
    	
    	prereq[0] = edge1;
    	prereq[1] = edge2;
    	prereq[2] = edge3;
    	prereq[3] = edge4;
    	prereq[4] = edge5;
    	
    	int[] result = findOrder(numCourses, prereq);
    	
    	System.out.print("[ ");
    	for (int i = 0; i < result.length; i++) {
    		System.out.print(result[i] + " ");
    	}
    	System.out.print("]");
    	
    }
}