public class islandPerimeter {
    public static int islandPerimeterSum(int[][] grid) {
        int totalPerimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
            	if (grid[i][j] == 1) {
                    totalPerimeter += countPerimeter(grid, i, j);
                }
            }
        }
        return totalPerimeter;
    }
    
    public static int countPerimeter(int[][] grid, int y, int x) {
        int perimeter = 0;
        //if left of x has no island or is end of map, perimeter + 1
        if (x-1 < 0 || grid[y][x-1] != 1) {
            perimeter += 1;
        }
        //if right of x has no island or is end of map, perimeter + 1
        if (x+1 >= grid[0].length || grid[y][x+1] != 1) {
            perimeter += 1;
        }
        //if top of y has no island or is end of map, perimeter + 1
        if (y-1 < 0 || grid[y-1][x] != 1) {
            perimeter += 1;
        }
        //if bottom of y has no island or is end of map, perimeter + 1
        if (y+1 >= grid.length || grid[y+1][x] != 1) {
            perimeter += 1;
        }
        
        return perimeter;
    }
    
    public static void main(String[] args) {
    	int[][] map = {{0,1,0,0},{1,1,1,1},{0,1,0,0},{1,1,0,0}}; // 18
    	
    	System.out.println(islandPerimeterSum(map));
    }
}