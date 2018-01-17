import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class calendarConflict {
	private static int countConflicts(List<int[]> events) {
		Collections.sort(events, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		
		for (int[] event : events) {
			
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		List<int[]> events = new ArrayList<>();
		
		events.add(new int[] {1, 4});
		events.add(new int[] {3, 5});
		events.add(new int[] {2, 7});
		events.add(new int[] {5, 10});
		
		System.out.println(countConflicts(events));
	}
}