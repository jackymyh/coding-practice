import java.util.ArrayList;
import java.util.Scanner;

public class libraryRoads {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int q = in.nextInt();
        //for(int a0 = 0; a0 < q; a0++){
        	long minCost = 0;
            int cities = in.nextInt();
            int roads = in.nextInt();
            int libCost = in.nextInt();
            int roadCost = in.nextInt();
            ArrayList<Integer>[] roadMap = new ArrayList[cities];
            
            for (int i = 0; i < cities; i++) {
            	roadMap[i] = new ArrayList<>();
            }
            
            for(int a1 = 0; a1 < roads; a1++){
                int city_1 = in.nextInt() - 1;
                int city_2 = in.nextInt() - 1;
                //road are bidirectional
                roadMap[city_1].add(city_2);
                roadMap[city_2].add(city_1);
               
            }
            
            if (roadCost >= libCost || roads == 0) {
            	// minCost will be a library in every city
            	minCost = libCost * cities;
            } else {
            	boolean[] visited = new boolean[cities];
            	for (int start = 0; start < cities; start++) {
            		int count = 0;
            		if (!visited[start]) {
						// calculate number of cities in this component
						count = DFS(roadMap, start, visited, cities, count);
						// one library + minimum amount of roads for each component
						minCost += ((count - 1) * roadCost) + libCost;
					}
            	}
            }
            
            System.out.println(minCost);
        //}
    }

	private static int DFS(ArrayList<Integer>[] roadMap, int start, boolean[] visited, int cities, int count) {
		if (!visited[start]) {
			visited[start] = true;
			for (int next : roadMap[start]) {
				count = DFS(roadMap, next, visited, cities, count);
			}
			count++;
		}
		return count;
	}

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        //int q = in.nextInt();
//        //for(int a0 = 0; a0 < q; a0++){
//        	long minCost = 0;
//            int cities = in.nextInt();
//            int roads = in.nextInt();
//            int libCost = in.nextInt();
//            int roadCost = in.nextInt();
//            boolean[][] roadMap = new boolean[cities][cities];
//            
//            for(int a1 = 0; a1 < roads; a1++){
//                int city_1 = in.nextInt() - 1;
//                int city_2 = in.nextInt() - 1;
//                //road are bidirectional
//                roadMap[city_1][city_2] = true;
//                roadMap[city_2][city_1] = true;
//               
//            }
//            
//            if (roadCost >= libCost || roads == 0) {
//            	// minCost will be a library in every city
//            	minCost = libCost * cities;
//            } else {
//            	boolean[] visited = new boolean[cities];
//            	for (int start = 0; start < cities; start++) {
//            		int count = 0;
//            		if (!visited[start]) {
//						// calculate number of cities in this component
//						count = DFS(roadMap, start, visited, cities, count);
//						// one library + minimum amount of roads for each component
//						minCost += ((count - 1) * roadCost) + libCost;
//					}
//            	}
//            }
//            
//            System.out.println(minCost);
//        //}
//    }
//
//	private static int DFS(boolean[][] roadMap, int start, boolean[] visited, int cities, int count) {
//		if (!visited[start]) {
//			visited[start] = true;
//			for (int next = 0; next < cities; next++) {
//				if (roadMap[start][next] == true) {
//					count = DFS(roadMap, next, visited, cities, count);
//				}
//			}
//			count++;
//		}
//		return count;
//	}
}

//public class Solution {
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int q = scan.nextInt();
//        for(int a0 = 0; a0 < q; a0++){
//        	HashMap<Integer, ArrayList<Integer>> cityMap = new HashMap<>();
//            int n = scan.nextInt();
//            int m = scan.nextInt();
//            int libraryCost = scan.nextInt();
//            int roadCost = scan.nextInt();
//            for (int i = 1; i <= n; i++) {
//                ArrayList<Integer> list = new ArrayList<Integer>();
//                list.add(i);
//                cityMap.put(i, list);
//            }
//
//            for (int a1 = 0; a1 < m; a1++) {
//                int x = scan.nextInt();
//                int y = scan.nextInt();
//                ArrayList<Integer> list1 = cityMap.get(x);
//                ArrayList<Integer> list2 = cityMap.get(y);
//                if (list1 != list2) {
//                    list1.addAll(list2);
//                    list2.forEach(i -> cityMap.put(i, list1));
//                }
//            }
//            if (libraryCost < roadCost)
//                System.out.println((long) n * libraryCost);
//            else {
//                long cost = 0;
//                for (ArrayList<Integer> list : cityMap.values()) {
//                    int size = list.size();
//                    if (size > 0) {
//                        cost += libraryCost;
//                        cost += (size - 1) * roadCost;
//                        list.removeIf(i -> true);
//                    }
//                }
//                System.out.println(cost);
//            }
//        }
//    }
//}