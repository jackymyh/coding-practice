class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class overlapRect {

	public static boolean isOverlap(Point L1, Point R1, Point L2, Point R2) {
		int top1 = Math.max(L1.y, R1.y);
		int bot1 = Math.min(L1.y, R1.y);
		int right1 = Math.max(L1.x, R1.x);
		int left1 = Math.min(L1.x, R1.x);

		int top2 = Math.max(L2.y, R2.y);
		int bot2 = Math.min(L2.y, R2.y);
		int right2 = Math.max(L2.x, R2.x);
		int left2 = Math.min(L2.x, R2.x);

		if (top1 <= bot2 || top2 <= bot1) {
			return false;
		}

		if (left1 >= right2 || left2 >= right1) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Point L1 = new Point(0, 4);
		Point R1 = new Point(4, 0);
		Point L2 = new Point(1, 1);
		Point R2 = new Point(3, 3);

		if (isOverlap(L1, R1, L2, R2)) {
			System.out.println("Rect Overlaps");
		} else {
			System.out.println("Rect Doesn't Overlap");
		}
	}
}