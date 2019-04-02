
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("points.txt");
		List<Point> pointList = new ArrayList<Point>();
		Scanner scanner = new Scanner(file);
		try {
			while (scanner.hasNextInt()) {

				pointList.add(new Point(scanner.nextInt(), scanner.nextInt()));
			}

			Point[] points = new Point[pointList.size()];
			points = pointList.toArray(points);
			Tree tree = Tree.createTree(points);
		

		} catch (NoSuchElementException e) {
			System.out.println("Podaj parzysta liczbe");
		}

	}
}
