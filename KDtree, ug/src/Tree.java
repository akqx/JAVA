import java.awt.Point;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class Tree {

	private Point root;
	private static Tree left;
	private Tree right;

	public Tree(Point root, Tree left, Tree right) {
		this.root = root;
		this.left = left;
		this.right = right;
	}

	public Tree getLeft() {
		return left;
	}

	public Point getRoot() {
		return root;
	}

	public Tree getRight() {
		return right;
	}

	public static Tree createTree(Point[] points) {
		Arrays.sort(points, Comparator.comparingDouble(Point::getY));
		Point[] pointsX = points.clone();
		Point[] pointsY = points.clone();
		Arrays.sort(pointsX, Comparator.comparingDouble(Point::getX));
		return changeTree(pointsX, pointsY, 0);
	}

	public static Tree changeTree(Point[] pointsX, Point[] pointsY, int d) {
		if (pointsX.length == 1)
			return new Tree(pointsX[0], null, null);

		Point mainPoint;
		Point[] x1, x2, y1, y2;
		if (d % 2 == 0) {
			System.out.println("PIONOWE: wg X");

			// szukanie mediany wœród x
			int middleNum = pointsX.length / 2;
			if (pointsX.length % 2 == 0)
				middleNum = middleNum - 1;
			mainPoint = pointsX[middleNum];

			// podzia³ na strone lewa i praw¹
			x1 = Arrays.copyOfRange(pointsX, 0, middleNum + 1);
			x2 = Arrays.copyOfRange(pointsX, middleNum + 1, pointsX.length);

			Point[][] yDivider = divideSY(pointsY, mainPoint, x1.length, x2.length);
			y1 = yDivider[0];
			y2 = yDivider[1];

		} else {
			System.out.println("POZIOME: wg Y");
			
			int middleNum = pointsY.length / 2;
			if (pointsY.length % 2 == 0)
				middleNum = middleNum - 1;
			mainPoint = pointsY[middleNum];

			// podzia³ na górê, dó³
			y1 = Arrays.copyOfRange(pointsY, 0, middleNum + 1);
			y2 = Arrays.copyOfRange(pointsY, middleNum + 1, pointsY.length);

			Point[][] xDivider = divideSX(pointsX, mainPoint, y1.length, y2.length);

			x1 = xDivider[0];
			x2 = xDivider[1];

		}
		
		System.out.println("Podzia³ przez " + (int) mainPoint.getX() + "," + (int) mainPoint.getY() + " POZIOM:" + d);
		
		Tree newLeft = changeTree(x1, y1, d + 1);
		Tree newRight = changeTree(x2, y2, d + 1);
		return new Tree(null, newLeft, newRight);
	}

	public static Point[][] divideSY(Point[] pointsY, Point median, int leftSize, int rightSize) {
		Point[][] div = new Point[2][];
		div[0] = new Point[leftSize];
		div[1] = new Point[rightSize];
		int leftCount = 0;
		int rightCount = 0;

		for (Point p : pointsY) {
			if (p.getX() <= median.getX()) {
				if (p.getX() == median.getX()) {
					if (p.getY() <= median.getY()) {
						div[0][leftCount] = p;
						leftCount++;
					} else {
						div[1][rightCount] = p;
						rightCount++;
					}
				} else {
					div[0][leftCount] = p;
					leftCount++;
				}
			} else {
				div[1][rightCount] = p;
				rightCount++;
			}
		}

		return div;
	}

	public static Point[][] divideSX(Point[] pointsX, Point median, int bottomSize, int topSize) {

		// podzia³ na na strone nad "median Point: w zadaniu nasze L", i pod
		Point[][] div = new Point[2][];
		div[0] = new Point[bottomSize];
		div[1] = new Point[topSize];
		int bottomCount = 0;
		int topCount = 0;

		for (Point p : pointsX) {
			if (p.getY() <= median.getY()) {
				if (p.getY() == median.getY()) {
					if (p.getX() <= median.getX()) {
						div[0][bottomCount] = p;
						bottomCount++;
					} else {
						div[1][topCount] = p;
						topCount++;
					}
				} else {
					div[0][bottomCount] = p;
					bottomCount++;
				}
			} else {
				div[1][topCount] = p;
				topCount++;
			}
		}

		return div;
	}

}
