import java.awt.Point;

public class PointsHelper {

	// wzór na orinetacjê :
	// https://www.gamedev.net/forums/topic/346146-triangle-orientation/
	public static int orientation(Point a, Point b, Point c) {
		int sum = 0;
		sum = (int) ((b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY()));

		return sum;
	}

	public static boolean isClockwise(Point previous, Point p, Point next) {
		return orientation(previous, p, next) > 0;
	}
}
