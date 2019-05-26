import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

public class Extrema {
	public static Point getMinimum(java.util.List<Point> minima, Point max) {
		Point minimum = max;
		for (Point point : minima)
			if (point.getY() < minimum.getY())
				minimum = point;
		return minimum;
	}

	public static Point getMaximum(java.util.List<Point> maxima, Point min) {
		Point maximum = min;
		for (Point point : maxima)
			if (point.getY() > maximum.getY())
				maximum = point;
		return maximum;
	}

	public static Point maxY(java.util.List<Point> points) {
		Point max = points.get(0);
		for (Point point : points)
			if (point.getY() > max.getY())
				max = point;
		return max;
	}

	public static Point minY(List<Point> points) {
		Point min = points.get(0);
		for (Point point : points)
			if (point.getY() < min.getY())
				min = point;
		return min;
	}

	public Kernel getKernel(List<Point> points) {
		List<Point> minima = new ArrayList<>();
		List<Point> maxima = new ArrayList<>();
		Point previous = points.get(points.size() - 1);
		for (int i = 1; i < points.size() - 1; i++) {

			Point p = points.get(i - 1);
			Point next = points.get(i);
			Point nextnext = points.get(i + 1);
			// wyznaczone warunki:
			// https://inf.ug.edu.pl/~lmielewczyk/teaching/ns/graf-geo-alg/lab/lab1.php

			if (
					(p.getY() > previous.getY() && p.getY() > next.getY() &&                                    PointsHelper.isClockwise(previous, p, next)) ||
					(p.getY() > previous.getY() && p.getY() == next.getY() && p.getY() > nextnext.getY() &&     PointsHelper.isClockwise(previous, p, nextnext))
			)maxima.add(p);

			if (
					(p.getY() < previous.getY() && p.getY() < next.getY() &&                                    PointsHelper.isClockwise(previous, p, next)) ||
					(p.getY() < previous.getY() && p.getY() == next.getY() && p.getY() < nextnext.getY() &&     PointsHelper.isClockwise(previous, p, nextnext))
			)minima.add(p);

			previous = p;
		}

		Point min = getMinimum(minima, maxY(points));
		System.out.println(min);

		Point max = getMaximum(maxima, minY(points));
		System.out.println(max);

		return new Kernel(points, min, max);
	}

}
