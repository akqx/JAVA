import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

public class Kernel {
	private List<Point> points;

	private Point min;
	private Point max;


	public Kernel(List<Point> points, Point min, Point max) {
		this.points = points;
		this.min = min;
		this.max = max;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Point getMin() {
		return min;
	}

	public void setMin(Point min) {
		this.min = min;
	}

	public Point getMax() {
		return max;
	}

	public void setMax(Point max) {
		this.max = max;
	}

	public boolean isExist() {
		if (getMax().getY() <= getMin().getY())
			return true;
		return false;
	}

}
